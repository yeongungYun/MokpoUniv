import java.sql.*;

public class MembersDBManager
{
    private String table;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public MembersDBManager(String database, String table)
    {
        this.table = table;

        // url = jdbc:mysql://localhost:(포트번호)/(데이터베이스명)
        String url = "jdbc:mysql://localhost:3306/" + database;
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

    public boolean tryLogin(String id, String password) // 로그인 시도
    {
        boolean ret;
        String sql = "select password from " + table + " where id = '" + id + "';";
        try
        {
            resultSet = statement.executeQuery(sql);
            if (!resultSet.next())
            {
                ret =  false;
            }
            else
            {
                String passwordInDB = resultSet.getString("password");
                ret = passwordInDB.equals(password); // 같으면 ret = true, 다르면 false
            }
            return ret;
        }

        catch (SQLException e)
        {
            e.printStackTrace();
            ret = false;
            return ret;
        }
    }

    public String trySignUp(String id, String password) // 회원가입 시도
    {
        String message;
        String sql = "select * from " + table +  " where id = '" + id + "';";
        String insertSql;
        try
        {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next())
            {
                message = "이미 존재하는 아이디입니다.";
            }
            else
            {
                insertSql = "insert into " + table + " values( '" + id + "', '" + password + "');";
                statement.executeUpdate(insertSql);
                message = "회원가입 성공";
            }
            return message;
        }
        catch (SQLException e)
        {
            e.getStackTrace();
            message = "회원가입 오류";
            return message;
        }
    }
}
