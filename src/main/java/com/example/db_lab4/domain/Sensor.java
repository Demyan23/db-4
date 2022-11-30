package com.example.db_lab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sensor {

    private Integer idsensor;
    private String info;
    private String clas;
    private String alertinfo;
    private String alertSettings;


}
