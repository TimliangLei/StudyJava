package com.inspur.dao;

import com.inspur.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //--------select part---------
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "isAdmin",column = "is_admin")
    })
    @Select("select id,user_id,user_name,nickName,password,is_admin from demo_user where user_id = #{userId}")
    public List<User> getByUserId(@Param("userId") String userId);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "isAdmin",column = "is_admin")
    })
    @Select("select id,user_id,user_name,nickName,password,is_admin from demo_user where id = #{id}")
    public User getByID(@Param("id") String id);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "isAdmin",column = "is_admin")
    })
    @Select("select id,user_id,user_name,nickName,password,is_admin from demo_user where user_name = #{userName}")
    public User getByUserName(@Param("userName") String userName);

    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "isAdmin",column = "is_admin")
    })
    @Select("select * from demo_user")
    public List<User> findAll();

    //--------insert part---------
    @Insert("INSERT INTO demo_user " +
            "(user_id,user_name,nickname,password,is_admin) " +
            "VALUES " +
            "(#{userId},#{userName},#{nickname},#{password},#{isAdmin})")
    @SelectKey(statement = "select LAST_INSERT_ID() as id",
            keyProperty = "id",keyColumn = "id",
            resultType = Integer.class,before = false)
    public void insert(User user);

    //--------update part---------
    @Update("update demo_user " +
            "set " +
            "user_id = #{userId}," +
            "nickname = #{nickname}," +
            "is_admin = #{isAdmin}," +
            "user_name = #{userName}," +
            "password = #{password}" +
            "where  id = #{id}")
    public void update(User user);

}
