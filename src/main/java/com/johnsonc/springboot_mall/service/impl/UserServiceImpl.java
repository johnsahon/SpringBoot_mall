package com.johnsonc.springboot_mall.service.impl;

import com.johnsonc.springboot_mall.dao.UserDao;
import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import com.johnsonc.springboot_mall.model.User;
import com.johnsonc.springboot_mall.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int createAccount(RegisterRquest rq) {
        return userDao.createAccount(rq);
    }

    @Override
    public User getAccountById(RegisterRquest rq) {
        return userDao.getAccountById(rq);
    }


}
