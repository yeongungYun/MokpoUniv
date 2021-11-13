import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class BooksDBManager
{
    private String table;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public BooksDBManager(String database, String table)
    {
        this.table = table;

        String url = "jdbc:mysql://localhost:3306/" + database;
        String userName = "root";
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

    public JTable makeTable()
    {
        JTable table = null;
        String sql = "select * from book";
        String[] header = {"번호", "제목", "저자", "대출", "예약"};
        ArrayList<String[]> tempList = new ArrayList<>();
        try
        {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                String bid = String.valueOf(resultSet.getInt("bid"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isBorrowBy = (resultSet.getString("isBorrowBy") == null ? "가능" : "불가");
                String isReserveBy = (resultSet.getString("isReserveBy") == null ? "가능" : "불가");
                tempList.add(new String[] {bid, title, author, isBorrowBy, isReserveBy});
            }

            String[][] contents = new String[tempList.size()][tempList.get(0).length];
            for (int i = 0; i < tempList.size(); ++i)
            {
                contents[i] = tempList.get(i);
            }

            // 테이블 각 열의 너비
            table = new JTable(contents, header);
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(1).setPreferredWidth(180);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.setRowHeight(25);

        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        finally
        {
            return table;
        }
    }

    public void searchInTable()
    {

    }
}
