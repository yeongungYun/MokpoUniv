import java.sql.*;

public class MembersDBManager
{
    private Connection connection;
    private Statement statement;
    ResultSet resultSet;

    public MembersDBManager()
    {
        // url = jdbc:mysql://localhost:(포트번호)/(데이터베이스명)
        String url = "jdbc:mysql://localhost:3306/members";
        // userName = 데이터베이스 아이디
        String userName = "root";
        // password = 데이터베이스 비밀번호
        String password = "root12345";

        try
        {
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            // statement.executeQuery( (쿼리문) );
        }
        catch (SQLException e)
        {
            e.getStackTrace();
        }
    }

    public String leaveLoginMessage(String id, String password)
    {
        try
        {
            resultSet = statement.executeQuery("select password from member where id = '" + id + "';");
            if (!resultSet.next())
            {
                return "존재하지 않는 아이디입니다.";
            }
            else
            {
                String passwordInDB = resultSet.getString("password");
                if (passwordInDB.equals(password))
                {
                    return "로그인 성공";
                }
                else
                {
                    return "비밀번호가 맞지 않습니다.";
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "로그인 오류";
        }
    }
}
