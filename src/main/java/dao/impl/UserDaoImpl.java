package dao.impl;

import dao.UserDao;
import models.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import shared.FactoryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class UserDaoImpl implements UserDao {
    private EntityManager em = FactoryManager.getEntityManager();

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void create(User user) {
        //try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        //} catch(Exception e) {
          //  LOGGER.error(e);
        //}
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch(Exception e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public void update(User user, Integer id) {
        try {

        } catch(Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {

        } catch(Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        List<User> listOfUsers = new ArrayList<>();
        try {

        } catch(Exception e) {
            LOGGER.error(e);
        }
        return listOfUsers;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<User> typed = em.createQuery(criteria);
            user = typed.getSingleResult();
        } catch(Exception e) {
            LOGGER.error(e);
        }

        return user;
    }
}
