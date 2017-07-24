package com.dzdy.springBoot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dzdy.springBoot.domain.UserInfo;
import com.dzdy.springBoot.mapper.UserInfoDao;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

}
