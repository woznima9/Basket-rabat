package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Rafał on 05.08.2018.
 */
@Data
@AllArgsConstructor
public class User {

    private String name;

    private Integer age;

    private String city;
}
