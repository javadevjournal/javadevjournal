package com.javadevjournal.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomListner implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent servletContextEvent) {
        System.out.println("from ServletContextListener: " +
                " context initialized");
        servletContextEvent.getServletContext().setAttribute("greeting", "Hello from project Greetings!!!");

    }

    @Override
    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    }
}
