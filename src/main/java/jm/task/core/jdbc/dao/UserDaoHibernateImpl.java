package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user (id mediumint PRIMARY KEY not null auto_increment, name VARCHAR(64), lastname VARCHAR(64), age INT(3))")
                    .executeUpdate();
            transaction.commit();
            session.close();
            //transaction.rollback();
        } catch (Exception e) {
            System.out.println("Не удалось создать таблицу");
        }
        System.out.println("Таблица создана");
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS user").executeUpdate();
            transaction.commit();
            session.close();

        } catch (Exception e){
            System.out.println("Не удалось удалить таблицу");
        }
        System.out.println("Таблица удалена");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            //User userNotTable = new User(name, lastName, age);
            session.save(new User(name, lastName, age));
            transaction.commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Не удалось сохранить юзеров");
        }
        System.out.println("Юзеры сохранены");
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Не удалось удалить юзеров");
        }
        System.out.println("Юзеры удалены");
    }

    @Override
    public List<User> getAllUsers() {

        List allUsers = new ArrayList<>();
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();
            allUsers = session.createCriteria(User.class).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Юзеры получены");
        }
        System.out.println("Юзеры получены");
        return allUsers;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        List allUsers = new ArrayList<>();
        try {
            Transaction transaction = session.beginTransaction();
            allUsers = session.createCriteria(User.class).list();

            for (Object oneUser : allUsers)
                session.delete(oneUser);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            System.out.println("Не удалось очистить юзеров");
        }

    }
}

