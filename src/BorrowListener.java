import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowListener implements ActionListener
{
    BorrowDialog dialog;
    String id;
    public BorrowListener(BorrowDialog dialog, String id)
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
            String message = BooksDatabase.getInstance().checkCanBorrow(bid);
            if (message.equals(Const.CAN))
            {
                BooksDatabase.getInstance().borrowBook(bid, id);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.BORROW_COMPLETE, Const.BORROW, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message, Const.BORROW, JOptionPane.PLAIN_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
