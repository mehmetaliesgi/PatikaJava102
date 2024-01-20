package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String lang;

    private Patika patika;
    private User educator;

    public Course(int id, String name, int user_id, int patika_id, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.lang = lang;
        this.patika = Patika.getFetch(patika_id);
        this.educator = User.getFetch(user_id);
    }

    public static ArrayList<Course> getList() {
        ArrayList<Course> courses = new ArrayList<>();
        Course obj;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM course");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int user_id = resultSet.getInt("user_id");
                int patika_id = resultSet.getInt("patika_id");
                String lang = resultSet.getString("lang");

                obj = new Course(id, name, user_id, patika_id, lang);
                courses.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public static boolean add(int user_id, int patika_id, String name, String lang) {
        String query = "INSERT INTO course (user_id, patika_id, name, lang) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, patika_id);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, lang);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Course> getListByUser(int userId) {
        ArrayList<Course> courses = new ArrayList<>();
        Course obj;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM course WHERE user_id = " + userId);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int user_id = resultSet.getInt("user_id");
                int patika_id = resultSet.getInt("patika_id");
                String lang = resultSet.getString("lang");

                obj = new Course(id, name, user_id, patika_id, lang);
                courses.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM course WHERE id = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean updateCourse(int id, String name, String lang, int patikaId, int educatorId) {
        String query = "UPDATE course SET name = ?, lang = ?, patika_id = ?, user_id = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lang);
            preparedStatement.setInt(3, patikaId);
            preparedStatement.setInt(4, educatorId);
            preparedStatement.setInt(5, id);

            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Course getFetch(int id) {
        String query = "SELECT * FROM course WHERE id = ?";
        Course obj = null;
        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                obj = new Course(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("user_id"),
                        resultSet.getInt("patika_id"), resultSet.getString("lang"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("lang"));
                System.out.println(resultSet.getInt("user_id"));
                System.out.println(resultSet.getInt("patika_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }

    public Patika getPatika() {
        return patika;
    }

    public User getEducator() {
        return educator;
    }
}
