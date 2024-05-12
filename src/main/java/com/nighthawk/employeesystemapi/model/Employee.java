package com.nighthawk.employeesystemapi.model;

import lombok.Data;

@Data
public class Employee {

    private long id;
    private String firstname;
    private String lastname;
    private String email;

}
