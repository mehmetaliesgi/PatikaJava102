package com.patikadev.Model;

import Collections.Student;
import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String userType;

    public User() {}

    public User(int id, String name, String username, String password, String userType) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static ArrayList<User> getList(String query) {
        ArrayList<User> userList = new ArrayList<>();
        //String sqlQuery = "SELECT * FROM users";
        User obj;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            //ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                obj = new User();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setUsername(resultSet.getString("username"));
                obj.setPassword(resultSet.getString("password"));
                obj.setUserType(resultSet.getString("userType"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean addUser(String name, String username, String password, String userType) {
        String query = "INSERT INTO users (name, username, password, \"userType\") VALUES (?, ?, ?, ?)";
        boolean result = false;
        User findUser = User.getFetch(username);
        if (findUser != null) {
            Helper.showMessage("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.");
            return false;
        }

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setObject(4, userType, Types.OTHER);

            result = preparedStatement.executeUpdate() != -1;

            if (result == false) {
                Helper.showMessage("error");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static User getFetch(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("userType"));
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static User getFetch(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("userType"));
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static boolean deleteUser(int userID) {
        String sql = "DELETE FROM users WHERE id = ?";

        boolean result = false;
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            result = preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void updateUser(int userID, String name, String username, String password, String userType) {
        String sql = "UPDATE users SET name = ?, username = ?, password = ?, \"userType\" = ? WHERE id = ?";

        User findUser = User.getFetch(username);
        if (findUser != null && findUser.getId() != userID) {
            Helper.showMessage("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz!");
        } else {
            try {
                PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setObject(4, userType, Types.OTHER);
                preparedStatement.setInt(5, userID);

                if (userType.equals("OPERATOR") || userType.equals("EDUCATOR") || userType.equals("STUDENT")) {
                    preparedStatement.executeUpdate();
                    Helper.showMessage("done");
                } else {
                    Helper.showMessage("Üyelik tipi sadece OPERATOR, STUDENT veya EDUCATOR olabilir.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ArrayList<User> searchUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                obj = new User();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setUsername(resultSet.getString("username"));
                obj.setPassword(resultSet.getString("password"));
                obj.setUserType(resultSet.getString("userType"));
                userList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static String searchQuery(String name, String username, String userType) {
        String sqlQuery = "SELECT * FROM users WHERE username ILIKE '{{username}}%' AND name ILIKE '{{name}}%'";
        sqlQuery = sqlQuery.replace("{{username}}", username);
        sqlQuery = sqlQuery.replace("{{name}}", name);
        if (!userType.isEmpty()) {
            sqlQuery += " AND \"userType\" = '{{userType}}'";
            sqlQuery = sqlQuery.replace("{{userType}}", userType);
        }
        return sqlQuery;
    }
}
