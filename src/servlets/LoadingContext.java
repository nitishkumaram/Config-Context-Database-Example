package servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class LoadingContext
 *
 */
@WebListener
public class LoadingContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoadingContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ctx) {
    	
    	System.out.println("Load Context");
    	Map<String,String> users=new HashMap<String,String>();
    	users.put("Jayesh", "abc");
    	users.put("praveen", "abcd");
    	users.put("sophia", "das");
    	
    	ServletContext context=ctx.getServletContext();
    	context.setAttribute("usersmap", users);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    	System.out.println(" destroy");
    }
	
}
