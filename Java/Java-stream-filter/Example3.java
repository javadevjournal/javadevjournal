import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Student {
    private String name;
    private int marks;

    Student(String _name, int _marks){
        this.name = _name;
        this.marks = _marks;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }

    static void printStudents(List<Student> studentList){
        studentList.forEach( e -> System.out.println("Student name : "+e.getName()+" Marks : "+e.getMarks()));
    }
}


public class Example3 {

    public static void main(String[] args) {
        Student[] studentArray = {new Student("Jacob", 80), new Student("Amanda", 70),
                new Student("Ashley", 85), new Student("Alexis", 90)};
        List<Student> studentList = Arrays.asList(studentArray);

        Predicate<Student> studentFilterPredicate = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getName().startsWith("A") && student.getMarks() > 80;
            }
        };

        List<Student> studentAList = studentList.stream()
                .filter(studentFilterPredicate)
                .collect(Collectors.toList());

        Student.printStudents(studentAList);
    }
}
