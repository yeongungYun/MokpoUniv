import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnListener implements ActionListener
{
    ReturnDialog dialog;
    String id;
    public ReturnListener(ReturnDialog dialog, String id)
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
            String message = BooksDatabase.getInstance().checkCanReturn(bid, dialog.getId());
            if (message.equals(Const.CAN))
            {
                BooksDatabase.getInstance().returnBook(bid);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.RETURN_COMPLETE, Const.RETURN, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message, Const.RETURN, JOptionPane.PLAIN_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
