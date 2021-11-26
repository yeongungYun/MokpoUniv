import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutListener implements ActionListener
{
    MainFrame mf;
    JDialog dialog;
    public LogoutListener(MainFrame mf, JDialog dialog)
    {
        this.mf = mf;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(Const.YES))
        {
            dialog.dispose();
            mf.changeScreen();
        }
        else if (e.getActionCommand().equals(Const.NO))
        {
            dialog.dispose();
        }
    }
}
