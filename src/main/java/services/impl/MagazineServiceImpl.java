package services.impl;


import dao.impl.MagazineDaoImpl;
import models.Magazine;
import services.MagazineService;

import java.util.List;

public class MagazineServiceImpl implements MagazineService {
    private MagazineDaoImpl magazineDao;
    private static MagazineServiceImpl magazineService;
    private MagazineServiceImpl() {
        this.magazineDao = new MagazineDaoImpl();
    }
    public static MagazineServiceImpl getMagazineService() {
        if(magazineService == null) {
            magazineService = new MagazineServiceImpl();
        }
        return magazineService;
    }
    @Override
    public void create(Magazine magazine) {
        this.magazineDao.create(magazine);
    }

    @Override
    public Magazine read(Integer id) {
        return this.magazineDao.read(id);
    }

    @Override
    public void update(Magazine magazine, Integer id) {
        this.magazineDao.update(magazine, id);
    }

    @Override
    public void delete(Integer id) {
        this.magazineDao.delete(id);
    }

    @Override
    public List<Magazine> readAll() {
        return this.magazineDao.readAll();
    }
}
