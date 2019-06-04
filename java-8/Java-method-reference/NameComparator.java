public class NameComparator {
    public int compareNames(Student s1, Student s2){
        return s1.getName().compareTo(s2.getName());
    }

    public Student compareMarks(Student s1,Student s2){
        return s1.getMarks() > s2.getMarks() ? s1 : s2;
    }
}
