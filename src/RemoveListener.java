import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveListener implements ActionListener
{
    RemoveDialog dialog;
    String id;
    public RemoveListener(RemoveDialog dialog, String id)
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
            String message = BooksDatabase.getInstance().checkCanRemove(bid);
            if (message.equals(Const.CAN))
            {
                BooksDatabase.getInstance().remove(bid);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.REMOVE_COMPLETE, Const.REMOVE, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message, Const.REMOVE, JOptionPane.PLAIN_MESSAGE);
            }
        }

        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
