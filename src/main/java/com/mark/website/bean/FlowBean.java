package com.mark.website.bean;

import com.mark.website.jdbc.JDBCConnectionFactory;
import com.mark.website.jdbc.JDBCExecutor;
import com.mark.website.model.Flow;
import com.mark.website.model.PagedResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mark on 2017/3/3.
 */
public class FlowBean {

    public PagedResult<Flow> getFlow(int page) {
        JDBCExecutor executor = new JDBCExecutor();
        List<Flow> flowList = new ArrayList<>();
        String sql = "SELECT * FROM flow ORDER BY createdate LIMIT ?,?";
        int size = JDBCConnectionFactory.getInstance().getPageSize();
        int start = (page-1)*size;
        try {
            List<Object> params = new ArrayList<>();
            params.add(start);
            params.add(size);
            ResultSet resultSet = executor.execute(sql,params);
            if (resultSet == null) return null;
            while (resultSet.next()){
                Flow flow = new Flow();
                flow.setId(Integer.valueOf(resultSet.getString("id")));
                flow.setUrl(resultSet.getString("url"));
                flow.setImage(resultSet.getString("image"));
                flow.setTitle(resultSet.getString("title"));
                flow.setDate(resultSet.getDate("createdate"));
                flowList.add(flow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int totalPages = (int) (getCount()+size-1)/size;

        PagedResult<Flow> result = new PagedResult<>(flowList,totalPages);
        return result;
    }

    public long getCount() {
        JDBCExecutor executor = new JDBCExecutor();
        String sql = "SELECT count(*) count FROM flow";
        try {
            ResultSet resultSet = executor.execute(sql,null);
            while (resultSet.next()) {
                return resultSet.getLong("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0l;
    }
}
