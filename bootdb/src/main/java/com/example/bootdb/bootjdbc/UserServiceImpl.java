/**
 * @description:
 * @author: Andy
 * @time: 2021/03/05 15:09
 */
package com.example.bootdb.bootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by fanyuexin on 2021/03/05
 */
@Service
public class UserServiceImpl implements UserService {

////    @Resource //默认是按照 byName 的方式注入
//    @Autowired //的注入方式是 byType 注入
//    @Qualifier("primaryDataSource")
    private JdbcTemplate jdbcTemplate;

    // 注入
    public UserServiceImpl(JdbcTemplate primaryJdbcTemplate) {
        this.jdbcTemplate = primaryJdbcTemplate;
    }

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update("INSERT INTO `bootdemo`.`user`(`id`, `name`, `age`, `email`) VALUES (?, ?, ?, ?);", user.getId(), user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update("INSERT INTO `bootdemo`.`user`(`id`, `name`, `age`, `email`) VALUES (?, ?, ?, ?);", user.getId(), user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public int deleteUserById(Long id) {
        return jdbcTemplate.update("DELETE FROM `bootdemo`.`user` WHERE ID = ?", id);
    }

    @Override
    public int deleteAllUser() {
        return jdbcTemplate.update("DELETE FROM `bootdemo`.`user`");
    }

    @Override
    public List<Map<String, Object>> getAllUser() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list;
    }

    @Override
    public User getUserById(Long id) {
        User user = jdbcTemplate.queryForObject("select * from user where ID = ?", new UserRowMapper(), id);
        return user;
    }
    // 可自定义 RowMapper
    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
}
