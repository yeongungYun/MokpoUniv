import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class BooksDBManager
{

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public BooksDBManager(String database)
    {
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

    public DefaultTableModel makeModel()
    {
        String sql = "select * from book";
        String[] header = {"번호", "제목", "저자", "대출", "예약"};
        ArrayList<String[]> tempList = new ArrayList<>();
        DefaultTableModel model;
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
            model = new DefaultTableModel(contents, header);
            return model;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }

    public DefaultTableModel resetTable()
    {
        return makeModel();
    }

    public DefaultTableModel searchInTable(boolean isTitle, String inputText)
    {
        DefaultTableModel model = makeModel();
        if (inputText == null)
        {
            return model;
        }
        String willSearchText = inputText.toLowerCase();
        willSearchText = willSearchText.replaceAll("\\s", ""); // 모든 공백 제거
        if (isTitle) // 제목 검색
        {
            for (int i = 0; i < model.getRowCount(); ++i)
            {
                String columnText = (String) model.getValueAt(i, 1);
                columnText = columnText.toLowerCase();
                columnText = columnText.replaceAll("\\s", "");
                if (columnText.indexOf(willSearchText) <= -1)
                {
                    model.removeRow(i);
                    --i;
                }
            }
        }
        else // 저자 검색
        {
            for (int i = 0; i < model.getRowCount(); ++i)
            {
                String columnText = (String) model.getValueAt(i, 2);
                columnText = columnText.toLowerCase();
                columnText = columnText.replaceAll("\\s", "");
                if (columnText.indexOf(willSearchText) <= -1)
                {
                    model.removeRow(i);
                    --i;
                }
            }
        }
        return model;
    }
}
