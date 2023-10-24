package dao.impl;

import dao.MagazineDao;
import models.Magazine;
import org.apache.log4j.Logger;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImpl implements MagazineDao {
    static String READ_ALL = "select * from magazine";
    static String CREATE = "insert into magazine(`name`, `description`, `author`, `price`) values (?, ?, ?, ?)";
    static String READ_BY_ID = "select * from magazine where id = ?";
    static String UPDATE_BY_ID = "update magazine set name = ?, description = ?, author = ?, price = ? where id = ?";
    static String DELETE_BY_ID = "delete from magazine where id = ?";
    private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
    private Connection connection;
    private PreparedStatement preparedStatement;
    public MagazineDaoImpl() {
        try {
            this.connection = ConnectionUtils.openConnection();
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            LOGGER.error(e);
        }
    }
    @Override
    public void create(Magazine magazine) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, magazine.getName());
            preparedStatement.setString(2, magazine.getDescription());
            preparedStatement.setString(3, magazine.getAuthor());
            preparedStatement.setInt(4, magazine.getPrice());

            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public Magazine read(Integer id) {
        Magazine magazine = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            magazine = new Magazine(result.getInt("id"), result.getString("name"), result.getString("description"),
                    result.getString("author"), result.getInt("price"));
        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return magazine;
    }

    @Override
    public void update(Magazine magazine, Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, magazine.getName());
            preparedStatement.setString(2, magazine.getDescription());
            preparedStatement.setString(3, magazine.getAuthor());
            preparedStatement.setInt(4, magazine.getPrice());
            preparedStatement.setInt(5, id);

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
    public List<Magazine> readAll() {
        List<Magazine> listOfMagazines = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                listOfMagazines.add(new Magazine(result.getInt("id"), result.getString("name"), result.getString("description"),
                        result.getString("author"), result.getInt("price")));
            }
        } catch(SQLException e) {
            LOGGER.error(e);
        }
        return listOfMagazines;
    }
}
