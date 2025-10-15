package com.vti.springdatajpa.dto;

import com.vti.springdatajpa.entity.AccountEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class DepartmentDto {

    private int id;

    private String name;


}
