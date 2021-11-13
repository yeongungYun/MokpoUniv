import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookTable extends JPanel
{
    JTable table;
    DefaultTableModel model;
    JScrollPane bookListScroll;

    public BookTable(MainFrame mf)
    {
        model = mf.getBooksDB().makeModel();
        table = new JTable(model);
        bookListScroll = new JScrollPane(table);
        bookListScroll.setPreferredSize(new Dimension(540, 680));
        setTableWidth();
        add(bookListScroll);
    }

    private void setTableWidth()
    {
        this.table.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.table.setRowHeight(25);
    }
}
