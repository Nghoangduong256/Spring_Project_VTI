package com.vti.springdatajpa.repository;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>
        , JpaSpecificationExecutor<AccountEntity> {

    @Query(value = "SELECT a.id, a.username, a.full_name, d.name AS department_name, p.name AS position_name"
            + " FROM Account a"
            + " LEFT JOIN Department d ON a.department_id = d.id"
            + " LEFT JOIN Position p ON a.position_id = p.id"
            , nativeQuery = true)
    List<Object[]> findAllAccount();

    @Query(value = "SELECT a.id, a.username, a.full_name, d.name AS department_name, p.name AS position_name"
            + " FROM Account a"
            + " LEFT JOIN Department d ON a.department_id = d.id"
            + " LEFT JOIN Position p ON a.position_id = p.id"
            + " where a.id = :id"
            , nativeQuery = true)
    Object findByAccountId(@Param("id") int id);

    @Query(value = "SELECT a.id, a.username, a.full_name, d.name AS department_name, p.name AS position_name"
            + " FROM Account a"
            + " LEFT JOIN Department d ON a.department_id = d.id"
            + " LEFT JOIN Position p ON a.position_id = p.id"
            + " where a.username like %:name% or a.full_name like %:name%"
            , nativeQuery = true)
    List<Object[]> findByAccountName(@Param("name") String name);

}
