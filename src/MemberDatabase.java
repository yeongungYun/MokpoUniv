import java.sql.*;

public class MemberDatabase
{
    private volatile static MemberDatabase instance = null;
    private Connection connection;


    private MemberDatabase()
    {
        initDatabase();
    }

    public static MemberDatabase getInstance()
    {
        if (instance == null)
        {
            synchronized (MemberDatabase.class)
            {
                instance = new MemberDatabase();
            }
        }
        return instance;
    }

    private void initDatabase()
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
            if (!checkExistsTable())
            {
                String sql =
                        "CREATE TABLE member ("
                                + "id VARCHAR(15) PRIMARY KEY,"
                                + "password VARCHAR(20)"
                                + ");";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
        }
        catch (SQLException e)
        {
            e.getStackTrace();
        }
    }

    private boolean checkExistsTable()
    {
        boolean ret = false;

        try
        {
            Statement statement = connection.createStatement();
            String sql = "SHOW TABLES LIKE 'member'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next())
            {
                ret = true;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ret;
    }

    public String login(String id, String password)
    {

        try
        {
            Statement statement = connection.createStatement();
            String sql = "SELECT password FROM member WHERE ID='" + id + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next() && resultSet.getString("password").equals(password))
            {
                return Const.LOGIN_COMPLETE;
            }
            else
            {
                return Const.LOGIN_FAILED;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return Const.LOGIN_ERROR;
        }
    }

    public String signUp(String id, String password)
    {
        try
        {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM member WHERE id='" + id + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 이미 존재하는 아이디
            {
                return Const.EXIST_SAME_ID;
            }
            else
            {
                String signUpSql = "INSERT INTO member values( '"
                        + id + "', '" + password + "');";
                statement.executeUpdate(signUpSql);
                return Const.SIGNUP_COMPLETE;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return Const.SIGNUP_ERROR;
        }
    }

    public boolean checkExistsTableTest()
    {
        return checkExistsTable();
    }
}