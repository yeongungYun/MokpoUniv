import javax.swing.*;
import java.awt.*;

public class BookTable extends JPanel
{
    private JTable table;
    private JScrollPane bookListScroll;
    private String[] header;

    public BookTable()
    {
        header = new String[] {"번호", "isbn", "제목", "저자", "출판사", "출판일", "대출", "예약"};
        table = new JTable(BooksDatabase.getInstance().initModel(
                new FreezeModel(header, 0)));
        table.getTableHeader().setReorderingAllowed(false); // 셀 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 셀 크기 조절 불가
        bookListScroll = new JScrollPane(table);
        bookListScroll.setPreferredSize(new Dimension(560, 690));
        setTableWidth();
        add(bookListScroll);
    }

    public void searchTable(boolean isTitleSelected, String searchText)
    {
        table.setModel(BooksDatabase.getInstance().SearchData(new FreezeModel(header, 0), isTitleSelected, searchText));
        setTableWidth();
    }

    public void resetTable()
    {
        table.setModel(BooksDatabase.getInstance().initModel(new FreezeModel(header, 0)));
        setTableWidth();
    }

    public void searchMyInfo(String id)
    {
        table.setModel(BooksDatabase.getInstance().searchMyInfo(new FreezeModel(header, 0), id));
        setTableWidth();
    }

    private void setTableWidth()
    {
        this.table.getColumnModel().getColumn(0).setPreferredWidth(2);  // bid
        this.table.getColumnModel().getColumn(1).setPreferredWidth(80);  // isbn
        this.table.getColumnModel().getColumn(2).setPreferredWidth(100); // title
        this.table.getColumnModel().getColumn(3).setPreferredWidth(60); // author
        this.table.getColumnModel().getColumn(4).setPreferredWidth(60); // publisher
        this.table.getColumnModel().getColumn(5).setPreferredWidth(50); // publish_date
        this.table.getColumnModel().getColumn(6).setPreferredWidth(2);  // is_borrow_by
        this.table.getColumnModel().getColumn(7).setPreferredWidth(2);  // is_reserve_by
        this.table.setRowHeight(25);
    }
}
