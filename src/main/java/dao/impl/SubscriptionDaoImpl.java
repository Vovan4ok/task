package dao.impl;

import dao.SubscriptionDao;
import models.Subscription;
import org.apache.log4j.Logger;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {
    static String READ_ALL = "select * from subscription";
    static String CREATE = "insert into subscription(`user_id`, `magazine_id`, `months_number`, `subscription_date`) values (?, ?, ?, ?)";
    static String READ_BY_ID = "select * from subscription where id = ?";
    static String DELETE_BY_ID = "delete from subscription where id = ?";
    private static Logger LOGGER = Logger.getLogger(SubscriptionDaoImpl.class);
    private Connection connection;
    private PreparedStatement preparedStatement;
    public SubscriptionDaoImpl() {
        try {
            this.connection = ConnectionUtils.openConnection();
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            LOGGER.error(e);
        }
    }
    @Override
    public void create(Subscription subscription) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setInt(1, subscription.getUserId());
            preparedStatement.setInt(2, subscription.getMagazineId());
            preparedStatement.setInt(3, subscription.getMonthsNumber());
            preparedStatement.setDate(4, new Date(subscription.getSubscriptionDate().getTime()));

            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public Subscription read(Integer id) {
        Subscription subscription = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            subscription = new Subscription(result.getInt("id"), result.getInt("user_id"), result.getInt("magazine_id"),
                    result.getInt("months_number"), result.getDate("subscription_date"));
        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return subscription;
    }

    @Override
    public void update(Subscription subscription, Integer id) {
        LOGGER.error("There is no update method fro subscription.");
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
    public List<Subscription> readAll() {
        List<Subscription> listOfSubscriptions = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                listOfSubscriptions.add(new Subscription(result.getInt("id"), result.getInt("user_id"), result.getInt("magazine_id"),
                        result.getInt("months_number"), result.getDate("subscription_date")));
            }
        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return listOfSubscriptions;
    }
}
