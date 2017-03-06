package com.mark.website.context; /**
 * @author mark on 2017/3/3.
 */

import com.mark.website.jdbc.JDBCPropertiesLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ContextParamListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public ContextParamListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        JDBCPropertiesLoader loader = new JDBCPropertiesLoader();
        loader.loadJDBCConfig(sce.getServletContext().getInitParameter("jdbc"));
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}
