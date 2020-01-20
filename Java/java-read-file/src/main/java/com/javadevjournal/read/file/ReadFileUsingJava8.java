package com.javadevjournal.read.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileUsingJava8 {

    private static final String FILE_LOCATION = "src/main/resources/read_java_file.txt";

    public static void main(String[] args) throws IOException {

        readLineByLine(FILE_LOCATION);
        readWithBuilder(FILE_LOCATION);
    }

    /*
     This method read the file line by line using Java 8 stream API
     */
    private static void readLineByLine(final String fileLocation) throws IOException {

        // create the path
        Path path = Paths.get(fileLocation);

        try(Stream<String> stream = Files.lines(path)){
            // read one line ar a time
            stream.forEach(System.out::println);
        }
    }

    /*
     Read all content line by line but add them to a StringBuilder
     */
    private static void readWithBuilder(final String fileLocation) throws IOException {

        StringBuilder sb = new StringBuilder();
        // create the path
        Path path = Paths.get(fileLocation);

        try(Stream<String> stream = Files.lines(path)){
            // read one line ar a time
            stream.forEach(s-> sb.append(s).append("/n"));
        }

        System.out.println(sb.toString());
    }
}
