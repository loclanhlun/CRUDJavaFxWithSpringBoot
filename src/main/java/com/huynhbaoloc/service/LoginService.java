package com.huynhbaoloc.service;

import com.huynhbaoloc.AccountException;
import com.huynhbaoloc.entity.Account;

public interface LoginService {

    Account login(String username, String password);
}
