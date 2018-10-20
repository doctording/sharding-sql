package com.example.demo.service.impl;

import com.example.demo.repository.mapper.TbUserMapper;
import com.example.demo.repository.model.TbUser;
import com.example.demo.repository.model.TbUserExample;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public int getCnt() {
        TbUserExample example = new TbUserExample();
        int cnt = tbUserMapper.countByExample(example);
        return cnt;
    }

    @Override
    public boolean addUserTest() {
        TbUser user = new TbUser();
        user.setUsername("test");
        user.setEmail("test");
        user.setNo(10000001);
        user.setStatus(true);
        user.setPassword("test");
        int cnt = tbUserMapper.insertSelective(user);
        return cnt > 0 ? true : false;
    }

    @Override
    public List<TbUser> getAllUser() {
        List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
        return userList;
    }

    @Override
    public List<TbUser> getUserByNos(List<Integer> nos) {
        TbUserExample example = new TbUserExample();
        example.createCriteria().andNoIn(nos);
        List<TbUser> userList = tbUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    public List<TbUser> getUserByIds(List<Long> ids) {
        TbUserExample example = new TbUserExample();
        example.createCriteria().andIdIn(ids);
        List<TbUser> userList = tbUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    public TbUser getUserById(Long id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }
}
