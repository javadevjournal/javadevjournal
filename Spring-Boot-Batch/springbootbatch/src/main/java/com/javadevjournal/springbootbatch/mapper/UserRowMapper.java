package com.javadevjournal.springbootbatch.mapper;

import com.javadevjournal.springbootbatch.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setFirstName(rs.getString("firstName"));
        user.setMiddleName(rs.getString("middleName"));
        user.setLastName(rs.getString("lastName"));
        user.setCity(rs.getString("city"));
        user.setId(rs.getInt("id"));
        return user;
    }
}
