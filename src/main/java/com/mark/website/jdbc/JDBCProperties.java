package com.mark.website.jdbc;

import java.util.Properties;

/**
 * @author mark on 2017/3/3.
 */
public class JDBCProperties {

    private String driver;
    private String url;
    private String user;
    private String password;
    private int size;

    public JDBCProperties(Properties prop) {
        this.driver = prop.getProperty("jdbc.driver","org.mariadb.jdbc.Driver");
        this.url = prop.getProperty("jdbc.url","jdbc:mariadb://localhost:3306/fresh");
        this.user = prop.getProperty("jdbc.user","root");
        this.password = prop.getProperty("jdbc.password","txlsy123455");
        try {
            this.size = Integer.valueOf(prop.getProperty("jdbc.size","11"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.size = 11;
        }

    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getSize() {
        return size;
    }
}
