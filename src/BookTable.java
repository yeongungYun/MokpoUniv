import javax.swing.*;
import java.awt.*;

public class BookTable extends JPanel
{
    private JTable table;
    private JScrollPane bookListScroll;

    public BookTable()
    {
        table = new JTable(BookDatabase.getInstance().initModel());
        table.getTableHeader().setReorderingAllowed(false); // 셀 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 셀 크기 조절 불가
        bookListScroll = new JScrollPane(table);
        bookListScroll.setPreferredSize(new Dimension(660, 690));
        setTableWidth();
        add(bookListScroll);
    }

    public void searchInTable(String searchCategory, String searchText)
    {
        table.setModel(BookDatabase.getInstance().searchData(searchCategory, searchText));
        setTableWidth();
    }

    public void resetTable()
    {
        table.setModel(BookDatabase.getInstance().initModel());
        setTableWidth();
    }

    public void searchMyInfo(String id)
    {
        table.setModel(BookDatabase.getInstance().myInformation(id));
        setTableWidth();
    }

    private void setTableWidth()
    {
        this.table.getColumnModel().getColumn(0).setPreferredWidth(2);  // bid
        this.table.getColumnModel().getColumn(1).setPreferredWidth(80);  // isbn-13
        this.table.getColumnModel().getColumn(2).setPreferredWidth(100); // title
        this.table.getColumnModel().getColumn(3).setPreferredWidth(60); // author
        this.table.getColumnModel().getColumn(4).setPreferredWidth(60); // publisher
        this.table.getColumnModel().getColumn(5).setPreferredWidth(50); // publish_date
        this.table.getColumnModel().getColumn(6).setPreferredWidth(50); // register_date
        this.table.getColumnModel().getColumn(7).setPreferredWidth(2);  // is_borrow_by
        this.table.getColumnModel().getColumn(8).setPreferredWidth(2);  // is_reserve_by
        this.table.setRowHeight(25);
    }
}
