package com.example.demo.service;


import com.example.demo.repository.model.TbUser;

import java.util.List;

public interface TbUserService {

    List<TbUser> getAllUser();

    TbUser getUserById(Long id);

    List<TbUser> getUserByIds(List<Long> ids);

    List<TbUser> getUserByNos(List<Integer> nos);

    int getCnt();

    boolean addUserTest();
}