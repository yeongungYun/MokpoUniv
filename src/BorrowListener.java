import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowListener implements ActionListener
{
    JDialog dialog;
    String id;
    public BorrowListener(JDialog dialog, String id)
    {
        this.dialog = dialog;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
