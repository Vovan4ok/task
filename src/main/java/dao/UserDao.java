package dao;

import models.User;
import shared.AbstractDao;

public interface UserDao extends AbstractDao<User> {
    User getUserByEmail(String email);
}
