package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl serDaoJDBCImpl = new UserDaoJDBCImpl();

    public void createUsersTable() {

        serDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {

        serDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

        serDaoJDBCImpl.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {

        serDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return serDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {

        serDaoJDBCImpl.cleanUsersTable();
    }
}
