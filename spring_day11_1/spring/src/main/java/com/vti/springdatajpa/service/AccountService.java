package com.vti.springdatajpa.service;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccount();

    public AccountDto getAccountByID(int id);

    public AccountEntity createAccount(AccountEntity accountEntity);

    public void updateAccount(AccountDto accountDto, int id);

    public void deleteAccount(int id);
}
