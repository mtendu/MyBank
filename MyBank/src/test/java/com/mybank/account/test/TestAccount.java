package com.mybank.account.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import com.mybank.common.constants.AccountType;
import com.mybank.pojo.Account;
import com.mybank.pojo.Customer;
import com.mybank.services.AccountServices;
import com.mybank.services.CustomerServices;
import com.mybank.services.TransactionServices;
import com.mybank.services.impl.AccountServicesImpl;
import com.mybank.services.impl.CustomerServiceImpl;
import com.mybank.services.impl.TransactionServicesImpl;
import com.mybank.util.hibernate.HibernateUtil;

public class TestAccount {
	
	SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
	@Test
	public void testOne() {
		
        
        AccountServices accountServices = new AccountServicesImpl();
        CustomerServices customerServices = new CustomerServiceImpl();
        TransactionServices transactionServices = new TransactionServicesImpl();
        
        Customer customer = customerServices.createUser("mtendu","mtendu");
        Customer customer1 = customerServices.createUser("appu","appu");
        
        Set<Customer> accountHolders = new HashSet<Customer>();
        accountHolders.add(customer);
        accountHolders.add(customer1);
        
        Set<Customer> authorizedUsers = new HashSet<Customer>();
        authorizedUsers.add(customer);
        authorizedUsers.add(customer1);
        
        
        Account account = accountServices.addAccount(1234, accountHolders, 3456, AccountType.SAVINGS_ACCOUNT, 0.1, 0.1);
        
        accountServices.addAutorizedUsers(account, customer, authorizedUsers);
        
        com.mybank.pojo.Transaction transaction = transactionServices.depositByCash(account, customer,100);
        
        com.mybank.pojo.Transaction transaction1 = transactionServices.withdrawByCash(account, customer,50);
        
        try{
        //Get Session
        sessionFactory = HibernateUtil.getSessionFactory();
        //session = sessionFactory.getCurrentSession();
        session = sessionFactory.openSession();
        System.out.println("Session created");
        //start transaction
        tx = session.beginTransaction();
         
        //Save the Model objects
        session.save(customer);
        session.save(customer1);
        session.save(account);
        session.save(transaction);
        session.save(transaction1);
        //Commit transaction
        tx.commit();
        System.out.println("Account ID="+account.getAccountId());
        
        session.close();
      
           
        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }
    }
	@Test
	public void testGetBalance(){
	 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	 EntityManager entitymanager = emfactory.createEntityManager( );
	 CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
	 CriteriaQuery<Account> criteria=cb.createQuery(Account.class);
	 Root<Account> account = criteria.from(Account.class);
	 criteria.select(account).where(cb.equal(account.get("ACCOUNT_NUMBER"),"1234"));
	 Account acc = (Account)((EntityManager) entitymanager).createQuery(criteria).setMaxResults(1).getSingleResult();

	         
     System.out.println("Your current balance is: " + acc.getAvailableBalance());
   
		}
		
		
}
