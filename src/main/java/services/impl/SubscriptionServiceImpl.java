package services.impl;

import dao.impl.SubscriptionDaoImpl;
import models.Subscription;
import services.SubscriptionService;

import java.sql.SQLException;
import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionDaoImpl subscriptionDao;
    private static SubscriptionServiceImpl subscriptionService;
    private SubscriptionServiceImpl() {
        this.subscriptionDao = new SubscriptionDaoImpl();
    }
    public static SubscriptionServiceImpl getSubscriptionService() {
        if(subscriptionService == null) {
            subscriptionService = new SubscriptionServiceImpl();
        }
        return subscriptionService;
    }
    @Override
    public void create(Subscription subscription) {
        this.subscriptionDao.create(subscription);
    }

    @Override
    public Subscription read(Integer id) {
        return this.subscriptionDao.read(id);
    }

    @Override
    public void update(Subscription subscription, Integer id) {
        this.subscriptionDao.update(subscription, id);
    }

    @Override
    public void delete(Integer id) {
        this.subscriptionDao.delete(id);
    }

    @Override
    public List<Subscription> readAll() {
        return this.subscriptionDao.readAll();
    }
}
