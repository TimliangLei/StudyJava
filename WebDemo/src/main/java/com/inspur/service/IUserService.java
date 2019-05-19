package com.inspur.service;

import com.inspur.pojo.User;
import com.inspur.pojo.UserArchive;

import java.util.List;

/**
 * leitianliang
 */
public interface IUserService {
    List<User> findAll();
    void save(User user);
    List<User> findUserByUserId(String userID);
    User findUserById(String id);
    UserArchive findUserArchiveById(String id);
    User findUserByUserName(String userName);
    void modify(User user);
}
