package servlets;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class NotifyListener
 *
 */
@WebListener
public class NotifyListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public NotifyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0) {
       System.out.println(" Attribute added "+arg0.getName()+"--"+arg0.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    	System.out.println(" Attribute replaced "+arg0.getName()+"--"+arg0.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
    	System.out.println(" Attribute Removed "+arg0.getName()+"--"+arg0.getValue());
    }
	
}
