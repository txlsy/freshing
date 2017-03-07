package com.mark.website.bean;

import com.mark.website.jdbc.JDBCExecutor;
import com.mark.website.model.Flow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark on 2017/3/3.
 */
public class FlowBean {

    public List<Flow> getFlow(int start, int end) {
        JDBCExecutor executor = new JDBCExecutor();
        List<Flow> flowList = new ArrayList<>();
        String sql = "SELECT * FROM flow";
        try {
            ResultSet resultSet = executor.execute(sql,new ArrayList());
            if (resultSet == null) return null;
            while (resultSet.next()){
                Flow flow = new Flow();
                flow.setId(Integer.valueOf(resultSet.getString("id")));
                flow.setUrl(resultSet.getString("url"));
                flow.setImage(resultSet.getString("image"));
                flow.setTitle(resultSet.getString("title"));
                flowList.add(flow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flowList;
    }
}
