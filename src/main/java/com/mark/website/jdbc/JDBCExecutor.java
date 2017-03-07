package com.mark.website.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author mark on 2017/3/3.
 */
public class JDBCExecutor implements SQLExecutor {

    public ResultSet execute(String sql, List params){
        try {
            Connection connection = JDBCConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1,params.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            connection.close();
            return resultSet;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
