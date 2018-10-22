package com.uv.ws.endpoint.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class HibernateUtility {

    public static SessionFactory factory;
    //to disallow creating objects by other classes.

    private HibernateUtility() {
    }
    //maling the Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {

        if (factory == null) {
            try {
                factory = new Configuration().configure().
                        buildSessionFactory();
            } catch (Exception e){
                e.printStackTrace();
            }


        }
        return factory;
    }
}