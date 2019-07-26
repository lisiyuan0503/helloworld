package com.czxy.controller;

import com.czxy.domain.Log;
import com.czxy.domain.User;
import com.czxy.service.LogService;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @PostMapping("/add")
    public ResponseEntity<String> add(HttpSession session, Log log){
        System.out.println("... 执行add方法");
        //获取session存储的user对象
        User loginU = (User) session.getAttribute("loginU");
        //将数据添加进log对象中
        log.setUid(loginU.getId());
        log.setUsername(loginU.getUsername());
        log.setOperat("add");
        log.setTime(new Date());
        //添加
        logService.addLog(log);
        return new ResponseEntity<>("add..OK",HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(HttpSession session, Log log){
        System.out.println("... 执行update方法");
        //获取session存储的user对象
        User loginU = (User) session.getAttribute("loginU");
        //将数据添加进log对象中
        log.setUid(loginU.getId());
        log.setUsername(loginU.getUsername());
        log.setOperat("update");
        log.setTime(new Date());
        //添加
        logService.addLog(log);
        return new ResponseEntity<>("update..OK",HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(HttpSession session, Log log){
        System.out.println("... 执行del方法");
        //获取session存储的user对象
        User loginU = (User) session.getAttribute("loginU");
        //将数据添加进log对象中
        log.setUid(loginU.getId());
        log.setUsername(loginU.getUsername());
        log.setOperat("del");
        log.setTime(new Date());
        //添加
        logService.addLog(log);
        return new ResponseEntity<>("del..OK",HttpStatus.OK);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Void> login(String username, String password, HttpSession session){
        //调用service的登录方法 返回user对象
        User user = userService.login(username, password);
        //如果不等于null 登陆成功  将对象存储到session域中
        if (user!=null){
            session.setAttribute("loginU",user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            //否则返回 500
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
