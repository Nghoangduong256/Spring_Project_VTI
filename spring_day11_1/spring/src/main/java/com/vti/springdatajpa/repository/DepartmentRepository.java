package com.vti.springdatajpa.repository;

import com.vti.springdatajpa.entity.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository  extends JpaRepository<DepartmentEntity, Integer>{

}
