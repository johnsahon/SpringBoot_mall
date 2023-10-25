package com.johnsonc.springboot_mall.service;

import com.johnsonc.springboot_mall.dao.UserDao;
import com.johnsonc.springboot_mall.dto.rq.RegisterRquest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public int createAccount(RegisterRquest rq) {
        return userDao.createAccount(rq);
    }

}
