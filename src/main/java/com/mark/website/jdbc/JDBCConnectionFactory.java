package com.mark.website.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mark on 2017/3/3.
 */
public class JDBCConnectionFactory {

    private static JDBCConnectionFactory instance;
    private JDBCProperties prop;

    private JDBCConnectionFactory(){}

    public static JDBCConnectionFactory getInstance() {
        if (instance == null) instance = new JDBCConnectionFactory();
        return instance;
    }

    public void setProperties(JDBCProperties properties){
        this.prop = properties;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(prop.getDriver());
        return DriverManager.getConnection(prop.getUrl(), prop.getUser(),prop.getPassword());
    }

}
