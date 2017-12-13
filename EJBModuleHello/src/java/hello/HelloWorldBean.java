package hello;

import javax.ejb.Stateless;

/**
 *
 * @author paranoia
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
