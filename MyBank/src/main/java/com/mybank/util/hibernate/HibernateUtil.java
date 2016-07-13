package com.mybank.util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.mybank.common.constants.AccountType;
import com.mybank.common.constants.CustomerType;
import com.mybank.common.constants.TransactionStatus;
import com.mybank.common.constants.TransactionType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Customer;
import com.mybank.pojo.CustomerAddress;
import com.mybank.pojo.CustomerDemographics;
import com.mybank.pojo.CustomerPhone;
import com.mybank.pojo.Transaction;
 
public class HibernateUtil {
 
    private static SessionFactory sessionFactory;
     
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(AccountType.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(CustomerDemographics.class);
            configuration.addAnnotatedClass(CustomerAddress.class);
            configuration.addAnnotatedClass(CustomerPhone.class);
            configuration.addAnnotatedClass(CustomerType.class);
            configuration.addAnnotatedClass(Transaction.class);
            configuration.addAnnotatedClass(TransactionType.class);
            configuration.addAnnotatedClass(TransactionStatus.class);
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}