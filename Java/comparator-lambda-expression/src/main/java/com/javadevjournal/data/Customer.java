package com.javadevjournal.data;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Customer implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
