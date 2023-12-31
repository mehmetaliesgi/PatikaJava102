package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTransactionManagement {
    public static void main(String[] args) {
        String sql = "INSERT INTO students (student_name, student_class) VALUES (?, ?)";
        Connection connection = null;

        /*
            Öncelikle neden Transaction management yapıyoruz onu açıklayalım. Birkaç data birbirine bağlı olabilir. Bu durumda ilk datamız eklendi, ikinci datamız eklendi fakat üçüncü datamızı
            eklerken bir problemle karşılaştık. Bu durumda diğer eklenmiş olan iki datayı geri almamız gerekecektir. Bunun için transaction management yapmamız gerekir. Bunu yapmak için daha önce
            herhangi bir datayı eklediğimizde direkt olarak database'e kayıt oluşturduğunu gördük. Fakat Connection sınıfımızın setAutoCommit adlı metodumuza parametre olarak false verdiğimizde
            sorguyu işler, bellekte tutar fakat database atmadan önce commit işlemi bekler. Bütün sorgularımızı yaptıktan sonra yine Connection sınıfımızın commit metodunu kullanarak hafızada bekleyen
            sorguları database'e işler. Tabi herhangi bir sqlexception almadıysa.
        */

        try {
            connection = DriverManager.getConnection(DBConncect.DB_URL, DBConncect.DB_USER, DBConncect.DB_PASSWORD);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Kılıç Arslan");
            preparedStatement.setInt(2, 5);
            preparedStatement.executeUpdate();

            if (true) {
                throw new SQLException();
            }

            preparedStatement.setString(1, "Alparslan Yıldırım");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();

            connection.commit();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
