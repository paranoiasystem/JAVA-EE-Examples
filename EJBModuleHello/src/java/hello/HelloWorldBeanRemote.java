package hello;

import javax.ejb.Remote;

/**
 *
 * @author paranoia
 */
@Remote
public interface HelloWorldBeanRemote {
    public String sayHello(String name);
}
