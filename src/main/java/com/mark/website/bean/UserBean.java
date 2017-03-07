package com.mark.website.bean;

import com.mark.website.jdbc.JDBCExecutor;
import com.mark.website.model.admin.Administrator;
import com.mysql.jdbc.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark on 2017/3/7.
 */
public class UserBean {

    public boolean checkAdmin(Administrator admin) {
        if (StringUtils.isEmptyOrWhitespaceOnly(admin.getName())) {
            return false;
        }

        JDBCExecutor executor = new JDBCExecutor();
        String sql = "SELECT * FROM administrator WHERE name = ? AND password = ?";
        List<String> params = new ArrayList<>();
        params.add(admin.getName());
        params.add(admin.getPassword());

        try {
            ResultSet resultSet = executor.execute(sql,params);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}