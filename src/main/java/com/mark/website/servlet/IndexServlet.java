package com.mark.website.servlet;

import com.mark.website.model.Flow;
import com.mark.website.service.FlowService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author mark on 2017/3/2.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FlowService service = new FlowService();
        List<Flow> flowList = service.getFlow(1, 20);
        if (flowList!=null) {
            for (Flow flow : flowList) {
                response.getWriter().println(flow.getTitle());
            }
        }
    }
}
