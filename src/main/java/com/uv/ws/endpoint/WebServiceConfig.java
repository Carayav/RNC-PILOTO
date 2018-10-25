package com.uv.ws.endpoint;


//import org.eclipse.persistence.annotations.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
//@PropertySource({ "classpath:persistence-jndi.properties" })
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

//  @Autowired
//  private Environment env;

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);

    return new ServletRegistrationBean(servlet , "/uv/ws/*");
  }

  @Bean(name = "rnc")
  public Wsdl11Definition defaultWsdl11Definition() {
    SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/RegistroNacionalCancer.wsdl"));

    return wsdl11Definition;
  }

//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
//          throws NamingException {
//    LocalContainerEntityManagerFactoryBean em
//            = new LocalContainerEntityManagerFactoryBean();
//    em.setDataSource(dataSource());
//
//    // rest of entity manager configuration
//    return em;
//  }
//
//  @Bean
//  public DataSource dataSource() throws NamingException {
//    System.out.printf("::::::::::::::::::::::::::::::::::\n\n");
//    System.out.printf("::::::::::::::::::::::::::::::::::\n\n");
//    System.out.printf("::::::::::::::::::::::::::::::::::\n\n");
//    return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
//  }

//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(emf);
//    return transactionManager;
//  }
//





//  @Bean
//  public DataSource dataSource(){
//    System.out.printf(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\n\n\n\n");
//    System.out.printf(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\n\n\n\n");
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.postgresql.Driver");
//    dataSource.setUrl("jdbc:postgresql://172.17.0.2:5432/rnc_bd??currentSchema=schema_rnc");
//    dataSource.setUrl("jdbc:postgresql://localhost:5432/rnc_bd??currentSchema=schema_rnc");
//    dataSource.setUsername( "postgres" );
//    dataSource.setPassword( "123456" );
//    return dataSource;
//  }
//
//  Properties hibernateProperties() {
//    return new Properties() {
//      {
//        setProperty("hibernate.jndi.url",
//                "jdbc/rnc");
//      }
//    };
//  }
}
