package com.mark.website.jdbc;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author mark on 2017/3/3.
 */
public interface SQLExecutor {
    ResultSet execute(String sql, List param);
}
