package com.slash.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listener end");
    }
}
