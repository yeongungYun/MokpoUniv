import javax.swing.*;
import java.awt.*;

public class BookTable extends JPanel
{
    private JTable table;
    private FreezeModel model;
    private JScrollPane bookListScroll;

    public BookTable()
    {
        model = BooksDatabase.getInstance().initModel();
        table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false); // 셀 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 셀 크기 조절 불가
        bookListScroll = new JScrollPane(table);
        bookListScroll.setPreferredSize(new Dimension(560, 680));
        setTableWidth();
        add(bookListScroll);
    }

    public void searchTable(boolean isTitleSelected, String searchText)
    {
        FreezeModel tempModel = BooksDatabase.getInstance().SearchData(isTitleSelected, searchText);
        table.setModel(tempModel);
        setTableWidth();
    }

    public void resetTable()
    {
        FreezeModel tempModel = BooksDatabase.getInstance().resetModel();
        table.setModel(tempModel);
        setTableWidth();
    }

    private void setTableWidth()
    {
        this.table.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.table.setRowHeight(25);
    }
}
