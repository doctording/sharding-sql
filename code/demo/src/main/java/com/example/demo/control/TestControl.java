package com.example.demo.control;

import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello test";
    }

    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAllUser() throws Exception {
        return tbUserService.getAllUser();
    }

    @RequestMapping(value="/test-in/{count}")
    public @ResponseBody  int getTestAllUser(@PathVariable("count")int count) {
        List<Long> ids = new ArrayList<>();
        for(int i = 1; i < count; i ++) {
            ids.add(1L * i);
        }
        List<TbUser> userList = tbUserService.getUserByIds(ids);
        return userList.size();
    }

    @RequestMapping(value="/test-count")
    public @ResponseBody int getUserCnt() {
        int cnt = tbUserService.getCnt();
        return cnt;
    }

    @RequestMapping(value="/add-test")
    public @ResponseBody boolean add() {
        return tbUserService.addUserTest();
    }

}
