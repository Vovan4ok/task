package dao.impl;

import dao.MagazineDao;
import models.Magazine;
import org.apache.log4j.Logger;
import shared.FactoryManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class MagazineDaoImpl implements MagazineDao {
    private EntityManager em = FactoryManager.getEntityManager();
    private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);

    @Override
    public void create(Magazine magazine) {
        try {
            em.getTransaction().begin();
            em.persist(magazine);
            em.getTransaction().commit();
        } catch(Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public Magazine read(Integer id) {
        Magazine magazine = null;
        try {
            magazine = em.find(Magazine.class, id);
        } catch(Exception e) {
            LOGGER.error(e);
        }
        return magazine;
    }

    @Override
    public void update(Magazine magazine, Integer id) {
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
    public List<Magazine> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM magazine e");
        } catch(Exception e) {
            LOGGER.error(e);
        }
        return (List<Magazine>) query.getResultList();
    }
}
