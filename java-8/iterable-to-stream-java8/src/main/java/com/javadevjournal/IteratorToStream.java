package com.javadevjournal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IteratorToStream {

    public static void main(String[] args) {
        Iterable<String> iterable
                = Arrays.asList("Testing", "Iterable", "To", "Java8", "Stream","Conversion");

        //Converting to the upper case
        List<String> upperCaseList= StreamSupport.stream(iterable.spliterator(), false)
                                                 .map(String::toUpperCase)
                                                 .collect(Collectors.toList());
    }
}
