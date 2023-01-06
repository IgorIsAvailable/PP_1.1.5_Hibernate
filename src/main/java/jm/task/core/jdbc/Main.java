package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class  Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Игорь", "Никитин", (byte) 23);
        System.out.println("User с именем – Игорь добавлен в базу данных");

        userService.saveUser("Полина", "Никитина", (byte) 23);
        System.out.println("User с именем – Полина добавлен в базу данных");

        userService.saveUser("Георгий", "Ефименко", (byte) 22);
        System.out.println("User с именем – Георгий добавлен в базу данных");

        userService.saveUser("Ксю", "Лагунова", (byte) 22);
        System.out.println("User с именем – Ксю добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
