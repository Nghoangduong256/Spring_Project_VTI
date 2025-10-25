package com.vti.springdatajpa.service;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.AccountEntity;
import com.vti.springdatajpa.form.CreateAccountForm;

import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccount();

    public AccountDto getAccountByID(int id);

    public List<AccountDto> getAccountByName(String name);

    public AccountDto createAccount(CreateAccountForm createAccountForm);

    public void updateAccount(CreateAccountForm createAccountForm, int id);

    public void deleteAccountById(int id);
}
