import java.sql.*;

public class BookDatabase
{
    private volatile static BookDatabase instance = null;
    private Connection connection;

    private BookDatabase()
    {
        initDataBase();
    }

    public static BookDatabase getInstance()
    {
        if (instance == null)
        {
            synchronized (BookDatabase.class)
            {
                instance = new BookDatabase();
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
                                + "isbn VARCHAR(15) NOT NULL,"
                                + "title VARCHAR(20) NOT NULL,"
                                + "author VARCHAR(15) NOT NULL,"
                                + "publisher VARCHAR(15) NOT NULL,"
                                + "publish_date VARCHAR(12) NOT NULL,"
                                + "register_date VARCHAR(12) NOT NULL,"
                                + "is_borrow_by VARCHAR(10),"
                                + "is_reserve_by VARCHAR(10)"
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
            String sql = "SHOW TABLES LIKE 'book';";
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

    public FreezeModel initModel(FreezeModel model)
    {
        String sql = "SELECT * FROM book;";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                String bid = String.valueOf(resultSet.getInt("bid"));
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String publishDate = resultSet.getString("publish_date");
                String registerDate = resultSet.getString("register_date");
                String isBorrowBy = (resultSet.getString("is_borrow_by") == null ? "O" : "X");
                String isReserveBy = (resultSet.getString("is_reserve_by") == null ? "O" : "X");
                String[] row = new String[] {bid, isbn, title, author, publisher, publishDate,
                        registerDate, isBorrowBy, isReserveBy};
                model.addRow(row);
            }
        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        return model;
    }

    public FreezeModel SearchData(FreezeModel model, String searchCategory, String searchText)
    {
        // 모든 공백 제거 후 소문자로 변경
        String text = searchText.toLowerCase().replaceAll("\\s", "");

        String sql = "SELECT * FROM book;";

        String searchField = "";
        if (searchCategory.equals(Const.TITLE))
        {
            searchField = "title";
        }
        else if (searchCategory.equals(Const.AUTHOR))
        {
            searchField = "author";
        }
        else if (searchCategory.equals(Const.PUBLISHER))
        {
            searchField = "publisher";
        }

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                String searchedRecord = resultSet.getString(searchField);
                // 모든 공백 제거 후 소문자로 변경
                searchedRecord = searchedRecord.toLowerCase().replaceAll("\\s", "");
                if (searchedRecord.contains(text)) // 포함되어 있으면
                {
                    String bid = String.valueOf(resultSet.getInt("bid"));
                    String isbn = resultSet.getString("isbn");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    String publishDate = resultSet.getString("publish_date");
                    String registerDate = resultSet.getString("register_date");
                    String isBorrowBy = (resultSet.getString("is_borrow_by") == null ? "O" : "X");
                    String isReserveBy = (resultSet.getString("is_reserve_by") == null ? "O" : "X");
                    String[] row = new String[] {bid, isbn, title, author, publisher, publishDate,
                            registerDate, isBorrowBy, isReserveBy};
                    model.addRow(row);
                }
            }
        }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        return model;
    }

    public FreezeModel myInformation(FreezeModel model, String id)
    {
        String sql = "SELECT * FROM book WHERE is_borrow_by='" + id + "' OR is_reserve_by='" + id + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                String bid = String.valueOf(resultSet.getInt("bid"));
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String publishDate = resultSet.getString("publish_date");
                String registerDate = resultSet.getString("register_date");
                String isBorrowBy = (resultSet.getString("is_borrow_by") == null ? "O" : "X");
                String isReserveBy = (resultSet.getString("is_reserve_by") == null ? "O" : "X");
                String[] row = new String[] {bid, isbn, title, author, publisher, publishDate,
                        registerDate, isBorrowBy, isReserveBy};
                model.addRow(row);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return model;
    }

    public String borrowCheckMessage(int bid)
    {
        String message;
        String sql = "SELECT * FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 해당 bid가 존재
            {
                if (resultSet.getString("is_borrow_by") == null) // 대출 가능
                {
                    message = Const.CAN;
                }
                else
                {
                    message = Const.ALREADY_BORROWED; // 이미 대출된 책
                }
            }
            else // 존재하지 않는 책 번호
            {
                message = Const.NON_EXISTENET_BID;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            message = Const.BORROW_ERROR;
        }
        return message;
    }

    public void borrow(int bid, String id)
    {
        String sql = "UPDATE book SET is_borrow_by='" + id + "' WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String returnCheckMessage(int bid, String id)
    {
        String message;
        String sql = "SELECT * FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 존재하는 bid
            {
                if (resultSet.getString("is_borrow_by") == null)
                {
                    message = Const.NOT_BORROWED_TO_ME;
                }
                else
                {
                    if (resultSet.getString("is_borrow_by").equals(id))
                    {
                        message = Const.CAN;
                    }
                    else
                    {
                        message = Const.NOT_BORROWED_TO_ME;
                    }
                }
            }
            else // 존재하지 않는 책 번호
            {
                message = Const.NON_EXISTENET_BID;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            message = Const.RETURN_ERROR;
        }
        return message;
    }

    public void returnBook(int bid)
    {
        String sql = "UPDATE book SET is_borrow_by=NULL WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String reserveCheckMessage(int bid)
    {
        String message;
        String sql = "SELECT * FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 존재하는 bid
            {
                if (resultSet.getString("is_reserve_by") == null) // 예약 가능
                {
                    message = Const.CAN;
                }
                else
                {
                    message = Const.ALREADY_RESERVED; // 이미 예약된 책
                }
            }
            else // 존재하지 않는 책 번호
            {
                message = Const.NON_EXISTENET_BID;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            message = Const.RESERVE_ERROR;
        }
        return message;
    }

    public void reserve(int bid, String id)
    {
        String sql = "UPDATE book SET is_reserve_by='" + id + "' WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String reserveCancelCheckMessage(int bid, String id)
    {
        String message;
        String sql = "SELECT * FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 해당 bid가 존재
            {
                if (resultSet.getString("is_reserve_by").equals(id)) // 반납 가능
                {
                    message = Const.CAN;
                }
                else
                {
                    message = Const.NOT_RESERVED_TO_ME; // 내가 예약한 책이 아님
                }
            }
            else // 존재하지 않는 책 번호
            {
                message = Const.NON_EXISTENET_BID;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            message = Const.RESERVE_CANCEL_ERROR;
        }
        return message;
    }

    public void reserveCancel(int bid)
    {
        String sql = "UPDATE book SET is_reserve_by=NULL WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void add(String isbn, String title, String author, String publisher,
                    String publishDate, String registerDate)
    {
        String sql = "INSERT INTO book (isbn, title, author, publisher, publish_date, register_date) VALUES"
                + "( '" + isbn + "', '" + title + "', '" + author + "', '"
                + publisher + "', '" + publishDate + "', '" + registerDate + "');";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String removeCheckMessage(int bid)
    {
        String message;
        String sql = "SELECT * FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) // 해당 bid가 존재
            {
                message = Const.CAN;
            }
            else // 존재하지 않는 책 번호
            {
                message = Const.NON_EXISTENET_BID;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            message = Const.REMOVE_ERROR;
        }
        return message;
    }

    public void remove(int bid)
    {
        String sql = "DELETE FROM book WHERE bid='" + bid + "';";
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
