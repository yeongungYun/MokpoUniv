import java.sql.*;

public class MembersDBManager
{
    public static void main(String[] args) throws SQLException
    {
        // url = jdbc:mysql://localhost:(포트번호)/(데이터베이스명)
        String url = "jdbc:mysql://localhost:3306/members";
        // userName = 데이터베이스 아이디
        String userName = "root";
        // password = 데이터베이스 비밀번호
        String password = "root12345";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        // statement.executeQuery( (쿼리문) );
        ResultSet resultSet = statement.executeQuery("select * from member");

        resultSet.next();
        // result.Set.getString( (속성명) );
        String name = resultSet.getString("id");
        String pw = resultSet.getString("password");
        System.out.println(name + ' ' + pw);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
