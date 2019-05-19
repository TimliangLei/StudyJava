package com.inspur.dao;

import com.inspur.pojo.UserArchive;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserArchiveMapper {

    @Insert("INSERT INTO demo_archives " +
            "(id,gender,birthday,education,school) " +
            "VALUES " +
            "(#{id},#{gender},#{birthday},#{education},#{school})")
    public void insert(UserArchive userArchive);

    @Select("select * from demo_archives where id = #{id}")
    public UserArchive getByID(@Param("id") String id);

    @Update("update demo_archives " +
            "set " +
            "gender = #{gender}," +
            "birthday = #{birthday}," +
            "school = #{school}," +
            "education = #{education}" +
            "where  id = #{id}")
    public void update(UserArchive user);
}
