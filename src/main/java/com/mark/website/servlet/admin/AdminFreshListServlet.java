package com.mark.website.servlet.admin;

import com.alibaba.fastjson.JSONWriter;
import com.mark.website.bean.FlowBean;
import com.mark.website.model.Flow;
import com.mark.website.model.PagedResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mark on 2017/3/8.
 */
public class AdminFreshListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        try {
             page = Integer.valueOf(request.getParameter("page"));
        } catch (NumberFormatException e) {
            System.out.println("===========flows 查询 页码 输入 有误============");
            e.printStackTrace();
        }

        FlowBean flowBean = new FlowBean();
        PagedResult<Flow> result = flowBean.getFlow(page);

        JSONWriter writer = new JSONWriter(response.getWriter());
        writer.writeObject(result);
        writer.flush();
        writer.close();
    }
}
