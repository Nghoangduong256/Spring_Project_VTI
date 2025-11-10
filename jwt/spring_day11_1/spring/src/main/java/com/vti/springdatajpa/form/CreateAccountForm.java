package com.vti.springdatajpa.form;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class CreateAccountForm {

    private String email;

    private String userName;

    private String fullName;

    private String password;

    private int departmentId;

    private int positionId;

}
