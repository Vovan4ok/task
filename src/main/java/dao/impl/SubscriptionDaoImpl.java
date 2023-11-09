package dao.impl;

import dao.SubscriptionDao;
import models.Subscription;
import org.apache.log4j.Logger;
import shared.FactoryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {
    private EntityManager em = FactoryManager.getEntityManager();
    private static Logger LOGGER = Logger.getLogger(SubscriptionDaoImpl.class);

    @Override
    public void create(Subscription subscription) {
        try {
            em.getTransaction().begin();
            em.persist(subscription);
            em.getTransaction().commit();
        } catch(Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public Subscription read(Integer id) {
        Subscription subscription = null;
        try {
            subscription = em.find(Subscription.class, id);
        } catch(Exception e) {
            LOGGER.error(e);
        }
        return subscription;
    }

    @Override
    public void update(Subscription subscription, Integer id) {
        LOGGER.error("There is no update method for subscription.");
    }

    @Override
    public void delete(Integer id) {
        try {
            Subscription subscription = read(id);
            em.getTransaction().begin();
            em.remove(subscription);
            em.getTransaction().commit();
        } catch(Exception e) {
            LOGGER.error(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subscription> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM subscription e");
        } catch(Exception e) {
            LOGGER.error(e);
        }
        return query.getResultList();
    }
}
