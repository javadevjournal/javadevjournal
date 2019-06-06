class Student {
    private String name;
    private int marks;
    private String gender;

    Student() {
        this.name = "none";
        this.marks = -1;
        this.gender = "none";
    }

    Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.marks = -1;
    }

    Student(String name, int marks, String gender) {
        this.name = name;
        this.marks = marks;
        this.gender = gender;
    }

    public static int compareMarks(Student s1, Student s2) {
        return s1.marks - s2.marks;
    }

    public static Student compareMarksOfTwo(Student s1, Student s2) {
        return s1.marks > s2.marks ? s1 : s2;
    }

    public int getMarks() {
        return marks;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}