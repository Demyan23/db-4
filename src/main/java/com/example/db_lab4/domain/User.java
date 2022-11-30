package com.example.db_lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer iduser;
    private Integer lvl;
    private String name;
    private String sirname;
    private Integer age;
    private String email;

}
