package JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations extends DBConncect{
    public static Statement statement;
    public static ResultSet data;

    public static void main(String[] args) {
        String sql = "SELECT * FROM STUDENTS";
        String insertSQL = "INSERT INTO students (student_name, student_class) VALUES ('Merzan Kurtoğlu', 2)";
        String preparedInsertSQL = "INSERT INTO students (student_name, student_class) VALUES (?,?)";
        String updateSTSQL = "UPDATE students SET student_name = 'Arif Pak' WHERE student_id = 3";
        String updatePSTSQL = "UPDATE students SET student_name = ? WHERE student_id = ?";

        //DBInsert(insertSQL);
        DBUpdate(updatePSTSQL);
        DBSelect(sql);
    }
    public static void DBSelect(String sql) {
        try {
            /*
                Statement interface ile veri tabanı tabloları üzerinde SQL komutlarını çalıştırırız. SQL komutuna göre hangi fonksiyonu kullanacağımız değişebilir.
                    - public ResultSet executeQuery(String sql): “SELECT” SQL komutuyla tablo üzerinde veri sorgulaması yapılacaksa bu fonksiyon kullanılmalıdır.
                      Sorgu sonucunda “ResultSet” tipinde bir nesne dönecektir. Bu nesne içinde sorgulanan tablodan dönen kayıtlar olacaktır.
                    - public int executeUpdate(String sql): DML ve DDL tipinde SQL komutları çalıştırılabilir. INSERT, UPDATE, DELETE gibi tablo verisinde değişikliği sağlayan komutlar işletilebilir.
                      Tabloda veya veri tabanında yapısal değişikliğe yol açan CREATE, DROP gibi komutlar da çalıştırılabilir.
                    - public boolean execute(String sql): Eğer çalıştıracağımız SQL komutu birden fazla sonuç dönecekse bu fonksiyonu kullanabiliriz.
             */

            // SELECT işlemi
            statement = DBConncect.connectDB(DB_URL, DB_USER, DB_PASSWORD).createStatement();
            data = statement.executeQuery(sql);

            while (data.next()) {
                System.out.println("ID: " + data.getInt("student_id"));
                System.out.println("AD: " + data.getString("student_name"));
                System.out.println("SINIF: " + data.getInt("student_class"));
                System.out.println("---------------------------------------------------");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DBInsert(String sql) {
        try {
            // statement kullanarak bu şekilde data eklemesi yapabiliriz ama dinamik olarak kullanıcıdan bir data beklersek burada biraz karışabilir durumlar.
            /*
            statement = DBConncect.connectDB(DB_URL, DB_USER, DB_PASSWORD).createStatement();
            data = statement.executeQuery(sql);
            statement.close();
            */

            // Bu nedenle PraperedStatement sınıfı kullanımı daha mantıklıdır.
            PreparedStatement preparedStatement = DBConncect.connectDB(DB_URL, DB_USER, DB_PASSWORD).prepareStatement("preparedInsertSQL");
            preparedStatement.setString(1,"Hakan Ulu");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void DBUpdate(String sql) {
        // Bu işlemi yapabilmek içinde yine Statement veya PreparedStatement kullanılabilir.
        try {
            /*
            // Statement ile kullanım bu şekilde
            statement = DBConncect.connectDB(DB_URL, DB_USER, DB_PASSWORD).createStatement();
            statement.executeUpdate(sql);
            statement.close();
            */


            PreparedStatement preparedStatement = DBConncect.connectDB(DB_URL, DB_USER, DB_PASSWORD).prepareStatement(sql);
            preparedStatement.setInt(2, 3);
            preparedStatement.setString(1, "Arif Paket");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
