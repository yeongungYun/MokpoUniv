import javax.swing.table.DefaultTableModel;

public class FreezeModel extends DefaultTableModel
{
    public FreezeModel(String[][] contents, String[] header)
    {
        super(contents, header);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
