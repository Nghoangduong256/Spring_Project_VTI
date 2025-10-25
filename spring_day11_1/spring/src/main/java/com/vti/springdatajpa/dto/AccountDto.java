package com.vti.springdatajpa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.vti.springdatajpa.entity.DepartmentEntity;
//import com.vti.springdatajpa.entity.PositionEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.swing.text.Position;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class AccountDto {

    private int id;

    private String userName;

    private String fullName;

    private String departmentName;

    private String positionName;


}
