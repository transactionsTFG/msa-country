package integration.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {
    @Produces
    @PersistenceContext(unitName="poolMSACountry")
    private EntityManager entityManager;
}
