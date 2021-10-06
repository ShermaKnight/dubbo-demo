package org.example.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserEntity implements Serializable {

    private Long id;
    private String userName;
    private String address;
    private BigDecimal salary;
    private Date createTime;
    private Date updateTime;
}
