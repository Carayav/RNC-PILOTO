package com.uv.ws.endpoint.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Arrays;

public class HibernateUtility {

    public static SessionFactory factory;
    //to disallow creating objects by other classes.

    private HibernateUtility() {
    }
    //maling the Hibernate SessionFactory object as singleton


    public static synchronized SessionFactory getSessionFactory() {

        System.out.printf("::::::::::::::::::::::::::::::::::");
        if (factory == null) {
            try {
//                DriverManagerDataSource dataSource = new DriverManagerDataSource();
//                dataSource.setDriverClassName("org.postgresql.Driver");
//                dataSource.setUrl("jdbc:postgresql://172.17.0.2:5432/rnc_bd??currentSchema=schema_rnc");
//                dataSource.setUrl("jdbc:postgresql://localhost:5432/rnc_bd??currentSchema=schema_rnc");
//                dataSource.setUsername( "postgres" );
//                dataSource.setPassword( "123456" );


                Configuration configuration = new Configuration().configure();
//                configuration.setProperty("hibernate.connection.datasource","java:comp/env/jdbc/rnc");
//                configuration.setProperty("hibernate.connection.username","postgres");
//                configuration.setProperty("hibernate.connection.password","123456");
//                configuration.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/rnc_bd?currentSchema=schema_rnc");
//                configuration.setProperty("hibernate.connection.url","jdbc:postgresql://172.17.0.2:5432/rnc_bd?currentSchema=schema_rnc");

                factory =  configuration.buildSessionFactory();

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return factory;
    }
}