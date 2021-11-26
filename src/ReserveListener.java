import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveListener implements ActionListener
{
    ReserveDialog dialog;
    String id;
    public ReserveListener(ReserveDialog dialog, String id)
    {
        this.dialog = dialog;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int bid = dialog.getBid();

        if (e.getActionCommand().equals(Const.YES) && bid > -1)
        {
            String message = BooksDatabase.getInstance().checkCanReserve(bid);
            if (message.equals(Const.CAN))
            {
                BooksDatabase.getInstance().reserveBook(bid, id);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.RESERVE_COMPLETE, Const.RESERVE, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message, Const.RESERVE, JOptionPane.PLAIN_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
