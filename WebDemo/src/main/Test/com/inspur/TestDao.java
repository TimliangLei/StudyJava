package com.inspur;

import com.inspur.dao.UserArchiveMapper;
import com.inspur.dao.UserMapper;
import com.inspur.pojo.User;
import com.inspur.pojo.UserArchive;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestDao {
    public static SqlSession getSession() {
        String resource = "/mybatis-config.xml";
        InputStream inputStream = TestDao.class.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }
    @Test
    public void insertTest(){
        SqlSession session = getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserArchiveMapper userArchiveMapper = session.getMapper(UserArchiveMapper.class);
        User user = new User();
        user.setUserId("1");
        user.setUserName("ltl");
        user.setNickname("Timliang");
        user.setPassword("1111");
        user.setIsAdmin("1");
        user.setArchive(new UserArchive());
        user.getArchive().setBirthday("1997");
        user.getArchive().setEducation("1");
        user.getArchive().setGender("1");
        userMapper.insert(user);
        user.getArchive().setId(user.getId());
        userArchiveMapper.insert(user.getArchive());
        session.commit();
    }
    @Test
    public void update(){
        SqlSession session = getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserArchiveMapper userArchiveMapper = session.getMapper(UserArchiveMapper.class);

        User user = new User();
        user.setId(12);
        user.setUserId("1");
        user.setUserName("ltl");
        user.setNickname("Timliang");
        user.setPassword("1111");
        user.setIsAdmin("1");
        user.setArchive(new UserArchive());
        user.getArchive().setId(12);
        user.getArchive().setBirthday("1998");
        user.getArchive().setEducation("1");
        user.getArchive().setGender("1");

        userMapper.update(user);
        userArchiveMapper.update(user.getArchive());
        session.commit();

    }

}
