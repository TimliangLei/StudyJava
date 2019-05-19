package com.proxy.sta;

import com.dao.IUserDao;
import com.dao.UserDao;

public class UserDaoProxy implements IUserDao {
    private  IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();
        System.out.println("提交事务...");
    }

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        IUserDao proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
