package com.example.demo.service;

import com.example.demo.repository.model.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TbUserTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testGetAllUsers(){
        Long startTime = System.currentTimeMillis();    //获取开始时间
        List<TbUser> userList = tbUserService.getAllUser();
        System.out.println("==============");
        long endTime = System.currentTimeMillis();    //获取结束时间
        int cnt = userList.size();
        System.out.println("==============");
        System.out.println(cnt);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }

    @Test
    public void testGetUserById(){
        Long id = 1L;
        TbUser user = tbUserService.getUserById(id);
        System.out.println("==============");
        System.out.println(user);
        System.out.println("==============");
    }

    @Test
    public void testGetUserByIds(){
        List<Long> ids = new ArrayList<>();
        int n = 10;
        for(int i = 1; i < n; i ++) {
            ids.add(10000L * i);
        }
        Long startTime = System.currentTimeMillis();    //获取开始时间

        List<TbUser> userList = tbUserService.getUserByIds(ids);

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(userList.size());
        System.out.println("==============");
    }

    @Test
    public void testGetUserByNos(){
        List<Integer> nos = new ArrayList<>();
        int n = 500;
        for(int i = 1; i < n; i ++) {
            nos.add(10 * i);
        }
        Long startTime = System.currentTimeMillis();    //获取开始时间

        List<TbUser> userList = tbUserService.getUserByNos(nos);

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println(userList.size());
        System.out.println("==============");
    }

    @Test
    public void testCmp(){
        int n = 1000;
        Long startTime = System.currentTimeMillis();    //获取开始时间
        for(int i = 0; i < n; i ++) {
             tbUserService.getUserById(1L * i);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }

    @Test
    public void testCmp2(){
        int n = 1000;
        Long startTime = System.currentTimeMillis();    //获取开始时间
        List<Long> ids = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            ids.add(1L * i);
        }
        tbUserService.getUserByIds(ids);
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }

    @Test
    public void testCnt(){
        Long startTime = System.currentTimeMillis();    //获取开始时间

        int cnt = tbUserService.getCnt();
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println(cnt);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }

    @Test
    public void addUserTest(){
        Long startTime = System.currentTimeMillis();    //获取开始时间

        boolean b = tbUserService.addUserTest();
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("==============");
        System.out.println(b);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        System.out.println("==============");
    }
}
