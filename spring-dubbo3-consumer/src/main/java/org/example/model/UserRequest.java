package org.example.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRequest {

    private String userName;
    private String address;
    private BigDecimal salary;
}
