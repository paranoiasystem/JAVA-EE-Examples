package book;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author paranoia
 */
public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "EJBModuleBookPU")
    private EntityManager entityManager;
}
