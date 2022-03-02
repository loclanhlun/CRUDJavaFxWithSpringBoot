package com.huynhbaoloc.service.impl;

import com.huynhbaoloc.AccountException;
import com.huynhbaoloc.entity.Account;
import com.huynhbaoloc.repo.AccountRepo;
import com.huynhbaoloc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account login(String username, String password) {
        if(StringUtils.isEmpty(username)){
            throw new AccountException("Please enter your user name.");
        }
        if(StringUtils.isEmpty(password)){
            throw new AccountException("Please enter your password.");
        }
        Account account = accountRepo.findByUserName(username).orElseThrow(
                () -> new AccountException("Please check your user name.")
        );
        if(!password.equals(account.getPassword())) {
            throw new AccountException("Please check your password.");
        }
        return account;
    }
}
