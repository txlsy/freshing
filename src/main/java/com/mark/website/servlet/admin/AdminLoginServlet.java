package com.mark.website.servlet.admin;

import com.mark.website.bean.UserBean;
import com.mark.website.model.admin.Administrator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author mark on 2017/3/6.
 */
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Administrator administrator = new Administrator();
        administrator.setName(username);
        administrator.setPassword(password);

        UserBean userBean = new UserBean();
        Boolean r = userBean.checkAdmin(administrator);

        Writer writer = response.getWriter();
        if(r) writer.write(this.getInitParameter("admin-index"));
        else writer.write(r.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/template/admin/login.html").include(request, response);
    }

}
