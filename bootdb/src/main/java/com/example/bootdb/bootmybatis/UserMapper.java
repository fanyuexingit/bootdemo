/**
 * @description:
 * @author: Andy
 * @time: 2021/03/08 14:48
 */
package com.example.bootdb.bootmybatis;

import com.example.bootdb.bootjdbc.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fanyuexin on 2021/03/08
 */
@Mapper
public interface UserMapper {

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE, EMAIL) VALUES(#{name}, #{age}, #{email})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("email") String email);

    @Update("UPDATE user SET age=#{age}, email=#{email} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE NAME = #{name}")
    int deleteByName(@Param("name") String name);

    @Delete("DELETE FROM USER")
    int deleteAll();

}

