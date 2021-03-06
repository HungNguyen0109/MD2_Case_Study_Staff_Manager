package com.company.service.user;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;

import java.io.IOException;
import java.util.List;

public class UserServiceIMPL implements IUserSevice {
    public static String PATH = "D:\\MD2-Case-Study-01\\MD2-Case-Study-01\\src\\com\\company\\data\\user.txt";
    public static List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(PATH);
    public static String PATH_LOGIN = "D:\\MD2-Case-Study-01\\MD2-Case-Study-01\\src\\com\\company\\data\\login.txt";
    public static List<User> userListLogin = new ConfigReadAndWriteFile<User>().readFromFile(PATH_LOGIN);

    @Override
    public List<User> findAllLogin() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_LOGIN,userListLogin);
        return userListLogin;
    }

    @Override
    public void saveLogin(User user)  {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH_LOGIN,userListLogin);
        userListLogin.clear();
        userListLogin.add(user);
    }

    @Override
    public void findById(int id) {
        Boolean checkId = false;
        for (int i = 0; i < userList.size(); i++) {
            if (id==userList.get(i).getId()){
                System.out.println(userList.get(i));
                checkId = true;
            }
        }
        if (checkId==false)
            System.err.println("ID không tồn tại");
    }

    @Override
    public List<User> findAll() {
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
        return userList;
    }

    @Override
    public void save(User user)  {
        userList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(PATH,userList);
    }

    @Override
    public void delete(int id) {
        Boolean checkId = false;
        for (int i = 0; i < userList.size(); i++) {
            if (id==userList.get(i).getId()){
                userList.remove(i);
                System.out.println("Xóa thành công!!!");
                checkId = true;
            }
        }
        if (checkId==false)
            System.err.println("ID không tồn tại");
    }
    public static boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }
    public static boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if(email.equals(userList.get(i).getEmail())){
                return true;
            }
        }
        return false;
    }


}
