package com.factory;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void save() {
        System.out.println("--------已经保存数据!!!--------");
    }
}
