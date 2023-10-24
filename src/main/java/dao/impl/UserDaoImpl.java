package dao.impl;

import dao.UserDao;
import models.User;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao {
    static String READ_ALL = "select * from user";
    static String CREATE = "insert into user(`name`, `surname`, `email`, `password`, `role`) values (?, ?, ?, ?, ?)";
    static String READ_BY_ID = "select * from user where id = ?";
    static String UPDATE_BY_ID = "update user set name = ?, surname = ?, email = ?, password = ?, role = ? where id = ?";
    static String DELETE_BY_ID = "delete from user where id = ?";

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;
    public UserDaoImpl() {
        try {
            this.connection = ConnectionUtils.openConnection();
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            LOGGER.error(e);
        }
    }
    @Override
    public void create(User user) {
        try{
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());

            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            user = new User(result.getInt("id"), result.getString("name"), result.getString("surname"),
                    result.getString("email"), result.getString("password"), result.getString("role"));


        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public void update(User user, Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        List<User> listOfUsers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                listOfUsers.add(new User(result.getInt("id"), result.getString("name"), result.getString("surname"),
                        result.getString("email"), result.getString("password"), result.getString("role")));
            }
        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return listOfUsers;
    }
}
