package applicationclienthello;

import hello.HelloWorldBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author paranoia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
        HelloWorldBeanRemote helloWorldBeanRemote = (HelloWorldBeanRemote) context.lookup("java:global/EJBModuleHello/HelloWorldBean!hello.HelloWorldBeanRemote");
        System.out.println("Server: " + helloWorldBeanRemote.sayHello("Marco"));
    }
    
}
