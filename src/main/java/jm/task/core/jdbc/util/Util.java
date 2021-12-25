package jm.task.core.jdbc.util;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?serverTimezone=Europe/Moscow";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dbvcv32FN327f";

    public static Connection getConnection (){
        Connection conection = null;

        try{
        //Driver driver = new FabricMySQLDriver();
        //DriverManager.registerDriver(driver);

        Class.forName(DRIVER);
        conection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Не удалось загрузить  драйвер"+ e);
        }

        return conection;
    }

}
