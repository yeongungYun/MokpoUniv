import java.sql.*;

public class BooksDatabase
{
    private volatile static BooksDatabase instance = null;
    private Connection connection;

    private BooksDatabase()
    {
        initDataBase();
    }

    public static BooksDatabase getInstance()
    {
        if (instance == null)
        {
            synchronized (BooksDatabase.class)
            {
                instance = new BooksDatabase();
            }
        }
        return instance;
    }

    private void initDataBase()
    {
        // url = jdbc:mysql://localhost:(포트번호)/(데이터베이스명)
        String url = "jdbc:mysql://localhost:3306/books";
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
                        "CREATE TABLE book ("
                                + "bid INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                                + "title VARCHAR(20),"
                                + "author VARCHAR(20),"
                                + "isBorrowBy VARCHAR(10),"
                                + "isReserveBy VARCHAR(10)"
                                + ");";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
            initModel();
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
            String sql = "SHOW TABLES LIKE 'book'";
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

    public FreezeModel initModel()
    {
        String sql = "select * from book";
        String[] header = {"번호", "제목", "저자", "대출", "예약"};
        int count = countRows();
        String[][] contents = new String[count][5];
        FreezeModel model = null;
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            for (int i = 0; i < count; ++i)
            {
                resultSet.next();
                String bid = String.valueOf(resultSet.getInt("bid"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isBorrowBy = (resultSet.getString("isBorrowBy") == null ? "가능" : "불가");
                String isReserveBy = (resultSet.getString("isReserveBy") == null ? "가능" : "불가");
                contents[i] = new String[] {bid, title, author, isBorrowBy, isReserveBy};
            }
            model = new FreezeModel(contents, header);

        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        return model;
    }

    private int countRows()
    {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM book";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            count = resultSet.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return count;
    }

    public FreezeModel resetModel()
    {
        return initModel();
    }

    public FreezeModel SearchData(boolean isTitleSelected, String searchText)
    {


        FreezeModel model = initModel();
        if (searchText.equals(""))
        {
            return model;
        }

        searchText = searchText.toLowerCase(); // 소문자로 변경
        searchText = searchText.replaceAll("\\s", ""); // 모든 공백 제거

        int searchColumn;
        if (isTitleSelected)
        {
            searchColumn = 1;
        }
        else
        {
            searchColumn = 2;
        }

        for (int i = 0; i < model.getRowCount(); ++i)
        {
            String textInColumn = (String) model.getValueAt(i, searchColumn);
            textInColumn = textInColumn.toLowerCase(); // 소문자로 변경
            textInColumn = textInColumn.replaceAll("\\s", ""); // 모든 공백 제거
            if (!textInColumn.contains(searchText)) // 포함되어 있는지 확인
            {
                model.removeRow(i);
                --i;
            }
        }
        return model;
    }
}
