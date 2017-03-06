package com.mark.website.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author mark on 2017/3/3.
 */
public class JDBCPropertiesLoader {

    public void loadJDBCConfig(String filePath) {
        Properties prop = new Properties();
        try {

            Enumeration<URL> ps = getClass().getClassLoader().getResources(filePath);
            while(ps.hasMoreElements()) {
                InputStream in = null;
                URL url = ps.nextElement();
                try {
                    in = url.openStream();
                    prop.load(in);

                    JDBCProperties properties = new JDBCProperties(prop);
                    JDBCConnectionFactory.getInstance().setProperties(properties);
                } finally {
                    if(in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
