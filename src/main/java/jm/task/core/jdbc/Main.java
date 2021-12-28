package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        User userSergey = new User("Сергей", "Никонов",  (byte)27);
        User userFedor  = new User("Федор", "Доронин", (byte) 27);
        User userNastya = new User("Настя", "Кочелаевская", (byte) 23);
        User userDima   = new User("Дима", "Карпов", (byte) 27);

        System.out.println(userSergey);
        System.out.println(userFedor);
        System.out.println(userNastya);
        System.out.println(userDima);

        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser(userSergey.getName(), userSergey.getLastName(), userSergey.getAge());
        userServiceImpl.saveUser(userFedor.getName(), userFedor.getLastName(), userFedor.getAge());
        userServiceImpl.saveUser(userNastya.getName(), userNastya.getLastName(), userNastya.getAge());
        userServiceImpl.saveUser(userDima.getName(), userDima.getLastName(), userDima.getAge());

        userServiceImpl.removeUserById(4);
        userServiceImpl.getAllUsers();
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();


    }
}
