package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//CREATE TABLE `tab_user` (
//  `id` INT(11) NOT NULL,
//  `username` VARCHAR(20) DEFAULT NULL,
//  `password` VARCHAR(20) DEFAULT NULL,
//  PRIMARY KEY (`id`)
//) ENGINE=INNODB DEFAULT CHARSET=utf8;
@Entity
@Table(name = "tab_user")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
