package com.vti.springdatajpa.service.ServiceImpl;

import com.vti.springdatajpa.dto.AccountDto;
import com.vti.springdatajpa.entity.AccountEntity;
import com.vti.springdatajpa.repository.AccountRepository;
import com.vti.springdatajpa.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<AccountDto> getAllAccount() {
        List<Object[]> ls = accountRepository.findAllAccount();
        List<AccountDto> accountDtos = new ArrayList<>();
        for (Object[] objects : ls) {
            AccountDto dto = new AccountDto();
            dto.setId((Integer) objects[0]);
            dto.setUserName((String) objects[1]);
            dto.setFullName((String) objects[2]);
            dto.setDepartmentName((String) objects[3]);
            accountDtos.add(dto);
        }
        return accountDtos;
    }

    @Override
    public AccountDto getAccountByID(int id) {
        Object[] object = (Object[]) accountRepository.findByAccountId(id);
        AccountDto accountDto = new AccountDto();
        accountDto.setId((Integer) object[0]);
        accountDto.setUserName((String) object[1]);
        accountDto.setFullName((String) object[2]);
        accountDto.setDepartmentName((String) object[3]);
        return accountDto;
    }

    @Override
    public AccountEntity createAccount(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    @Override
    public void updateAccount(AccountDto accountDto, int id) {
        AccountEntity account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        //Thiết lập những trường cần update
        account.setUserName(accountDto.getUserName());
        account.setFullName(accountDto.getFullName());
//        account.setEmail(accountDto.getEmail());
//        account.setDepartment(accountDto.getDepartment());
//        account.setPosition(accountDto.getPosition());

        AccountEntity updated = accountRepository.save(account);
        mapper.map(updated, AccountDto.class);
    }

    @Override
    public void deleteAccount(int id) {
        if (!accountRepository.existsById(id)){
            throw new RuntimeException("Account not found");
        }

        accountRepository.deleteById(id);
    }
}
