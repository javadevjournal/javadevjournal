package spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args){
        List<Student> studentList = Arrays.asList(new Student("Alex", 23), new Student("Albert", 29), new Student("Brad", 33), new Student("Fred", 38), new Student("Max", 43));


        StreamSupport.stream(new StudentSpliterator(studentList), true).forEach(e -> System.out.println("====>" + e.getAge()));
        System.out.println(StreamSupport.stream(new StudentSpliterator(studentList), true).mapToInt(Student::getAge).sum());

        StreamSupport.stream(new StudentSpliterator(studentList), false).forEach(e -> System.out.println("====>" + e.getAge()));
        System.out.println(StreamSupport.stream(new StudentSpliterator(studentList), false).mapToInt(Student::getAge).sum());
    }
}
