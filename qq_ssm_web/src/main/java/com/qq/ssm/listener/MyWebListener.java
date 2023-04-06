package com.qq.ssm.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * CLASS Simple Description //TODO <br><br>
 *
 * <p>
 * Class detailed description, effection, usage,etc. //TODO
 * </p >
 * <br>
 * author: qiqin 2022/8/15 16:28
 */
@WebListener
public class MyWebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
