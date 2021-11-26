import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveCancelListener implements ActionListener
{
    ReserveCancelDialog dialog;
    String id;
    public ReserveCancelListener(ReserveCancelDialog dialog, String id)
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
            String message = BooksDatabase.getInstance().checkCanReserveCancel(bid, dialog.getId());
            if (message.equals(Const.CAN))
            {
                BooksDatabase.getInstance().reserveCancel(bid);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.RESERVE_CANCEL_COMPLETE, Const.RESERVE_CANCEL, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message, Const.RESERVE_CANCEL, JOptionPane.PLAIN_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
