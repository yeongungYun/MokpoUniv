import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener
{
    private LoginDialog dialog;
    private MainFrame mf;
    public LoginListener(MainFrame mf, LoginDialog dialog)
    {
        this.mf = mf;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(Const.LOGIN))
        {
            String id = dialog.getId();
            String password = dialog.getPassword();
            String message = MembersDatabase.getInstance().login(id, password);
            if (message.equals(Const.LOGIN_COMPLETE))
            {
                mf.changeScreen(id);
                dialog.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message,
                        "로그인", JOptionPane.PLAIN_MESSAGE);
            }

            if (message.equals(Const.LOGIN_FAILED))
            {
                dialog.initAll();
            }
        }

        else if (e.getActionCommand().equals(Const.CLOSE))
        {
            dialog.dispose();
        }
    }
}
