package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (id mediumint PRIMARY KEY not null auto_increment, name VARCHAR(64), lastname VARCHAR(64), age INT(3))");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу");
        }
        System.out.println("Таблица создана");
    }

    public void dropUsersTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS user");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }
        System.out.println("Таблица удалена");

    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(name, lastname, age) VALUES(?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Не удалось сохранить юзеров");
        }

    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            preparedStatement.setLong(1,id);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить юзеров");
        }
        System.out.println("Юзеры удалены");
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from user");) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось получить юзеров");
        }
        System.out.println("Юзеры получены");
        return allUsers;
    }

    public void cleanUsersTable () {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM user");
        } catch (SQLException e) {
            System.out.println("Не удалось очистить юзеров");
        }
        System.out.println("Юзеры очищены");
    }

}


