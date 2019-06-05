package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {
        List<String> words= Arrays.asList("Java Dev Journal","Java", "Spring Boot","Java 8");

        List<Integer> wordCount = words.stream()
                        .map(String::length)
                        .collect(Collectors.toList());

        wordCount.forEach(System.out::println);
    }
}
