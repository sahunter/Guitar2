package com.guitar.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.guitar.model.GuitarDAOImpl;
import com.guitar.model.WebService;

/**
 * Application Lifecycle Listener implementation class WebListener
 *
 */
@WebListener
public class GuitarListener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public GuitarListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try{
			Context inticontext=new InitialContext();
			Context envContext=(Context)inticontext.lookup("java:/comp/env");
			DataSource dataSource=(DataSource)envContext.lookup("jdbc/Test1");
			ServletContext context=arg0.getServletContext();
			context.setAttribute("webService", new WebService(new GuitarDAOImpl(dataSource),new InventoryDAOImpl(dataSource)));
			//in
		}catch(NamingException e){
			throw new RuntimeException(e);
		}
    }
	
}
