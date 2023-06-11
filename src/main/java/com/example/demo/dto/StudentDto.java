package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    public static final String COLUMNS = "nom, prenom, age, email, preferredNumber";

    private String nom;
    private String prenom;
    private int age;
    private String email;
    private int preferredNumber;
}

