package com.inspur.service.impl;

import com.inspur.dao.UserArchiveMapper;
import com.inspur.dao.UserMapper;
import com.inspur.pojo.User;
import com.inspur.pojo.UserArchive;
import com.inspur.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserArchiveMapper archiveMapper;

    @Override
    @Transactional("mybatisTransactionManager")
    public void save(User user) {
        userMapper.insert(user);
        user.getArchive().setId(user.getId());
        archiveMapper.insert(user.getArchive());
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findUserByUserId(String userID) {
        return userMapper.getByUserId(userID);
    }

    @Override
    public void modify(User user) {
        userMapper.update(user);
        user.getArchive().setId(user.getId());
        archiveMapper.update(user.getArchive());
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Override
    public User findUserById(String id) {
        return userMapper.getByID(id);
    }

    @Override
    public UserArchive findUserArchiveById(String id) {
        return archiveMapper.getByID(id);
    }
}
