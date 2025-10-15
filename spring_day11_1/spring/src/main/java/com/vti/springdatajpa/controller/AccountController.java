package com.vti.springdatajpa.controller;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.AccountEntity;
import com.vti.springdatajpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //get all
    @GetMapping
    public ResponseEntity<?> getAllAccount() {
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }

    //get by id
    @GetMapping("/{id}")
    public  ResponseEntity<?> getAccountById(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(accountService.getAccountByID(id), HttpStatus.OK);
    }

    //create account
    @PostMapping
    public AccountEntity createAccount (@RequestBody AccountEntity accountEntity){
        return accountService.createAccount(accountEntity);
    }

    //update account
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable(name = "id") int id, @RequestBody AccountDto accountDto){
        accountService.updateAccount(accountDto, id);
        return new ResponseEntity<>("Update account success", HttpStatus.OK);
    }

    //Delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Delete account success", HttpStatus.OK);
    }
}
