import javax.swing.table.DefaultTableModel;

public class FreezeModel extends DefaultTableModel
{
    public FreezeModel(String[] header, int n)
    {
        super(header, n);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
