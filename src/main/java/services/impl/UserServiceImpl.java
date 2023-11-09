package services.impl;

import dao.impl.UserDaoImpl;
import models.User;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;
    private static UserServiceImpl userService;
    private UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }
    public static UserServiceImpl getUserService() {
        if(userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public void create(User user) {
        this.userDao.create(user);
    }

    @Override
    public User read(Integer id) {
        return this.userDao.read(id);
    }

    @Override
    public void update(User user, Integer id) {
        this.userDao.update(user, id);
    }

    @Override
    public void delete(Integer id) {
        this.userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return this.userDao.readAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userDao.getUserByEmail(email);
    }
}
