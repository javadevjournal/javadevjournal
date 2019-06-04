import java.util.Arrays;
import java.util.function.BiFunction;

interface IStudentComparator{
    Student getResult(Student s1,Student s2);
}

interface IStudent{
    Student create();
}

@FunctionalInterface
interface IStudentCreator {
    Student createStudent(String name, int marks, String gender);
}


class Main{
    public static void main(String[] args) {
        Student[] studentArray = new Student[3];

        studentArray[0] = new Student("Alex", 24, "male");
        studentArray[1] = new Student("Liza", 22, "female");
        studentArray[2] = new Student("Bob", 26, "male");

        Arrays.sort(studentArray, (Student s1, Student s2) -> Student.compareMarks(s1,s2));

        for (Student s:studentArray){
            System.out.print(s.getName()+" ");
        }

        //static method reference
        //example 1
        Arrays.sort(studentArray, Student::compareMarks);

        //example 2
        BiFunction<Student,Student,Student> comparator = Student::compareMarksOfTwo;
        Student result = comparator.apply(studentArray[0],studentArray[1]);
        System.out.println(result.getName()+ " "+result.getMarks()+" "+result.getGender());

        //example 3
        IStudentComparator comparator1 = Student::compareMarksOfTwo;
        Student result1 = comparator1.getResult(studentArray[0],studentArray[1]);
        System.out.println(result1.getName()+ " "+result1.getMarks()+" "+result1.getGender());


        //Instance method reference of a particular object
        //example 1
        NameComparator comparator2 = new NameComparator();
        Arrays.sort(studentArray, comparator2::compareNames);

        //example 2
        NameComparator comparator3 = new NameComparator();
        BiFunction<Student,Student,Student> biFunction = comparator3::compareMarks;
        Student result2 = biFunction.apply(studentArray[0],studentArray[1]);
        System.out.println(result2.getName()+ " "+result2.getMarks()+" "+result2.getGender());

        //example 3
        Student result4 = new NameComparator().compareMarks(studentArray[0],studentArray[1]);
        System.out.println(result4.getName()+ " "+result4.getMarks()+" "+result4.getGender());

        //example 4
        IStudentComparator comparator4 = new NameComparator()::compareMarks;
        Student result5 = comparator4.getResult(studentArray[0],studentArray[1]);
        System.out.println(result5.getName()+ " "+result5.getMarks()+" "+result5.getGender());

        //Instance method reference of an arbitrary object of a particular type
        String[] nameArray = new String[3];
        int i = 0;
        for(Student s : studentArray){
            nameArray[i++] = s.getName();
        }

        Arrays.sort(nameArray,String::compareTo);

        //Constructor reference

        //1. Constructor with no parameter
        IStudent iStudent = Student::new;
        Student s = iStudent.create();

        System.out.println(s.getName() + " "+s.getMarks()+" "+s.getGender());

        //2. constructor with two parameters
        BiFunction<String,String,Student> biFunction1 = Student::new;
        Student s1 = biFunction1.apply("Alex","male");
        System.out.println(s1.getName() + " "+s1.getMarks()+" "+s1.getGender());

        //Constructor with three or more than three parameters
        IStudentCreator studentCreator2 = Student::new;
        Student s2 = studentCreator2.createStudent("Alex",24,"male");
        System.out.println(s2.getName() + " "+s2.getMarks()+" "+s2.getGender());

    }
}
