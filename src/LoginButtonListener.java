import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener
{
    private LoginDialog dialog;
    private MainFrame mf;
    public LoginButtonListener(MainFrame mf, LoginDialog dialog)
    {
        this.mf = mf;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(LoginConst.LOGIN))
        {
            String id = dialog.getId();
            String password = dialog.getPassword();
            String message = MembersDatabase.getInstance().login(id, password);
            if (message.equals(LoginConst.LOGIN_COMPLETE))
            {
                mf.changeScreen();
                dialog.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                        message,
                        "로그인", JOptionPane.PLAIN_MESSAGE);
            }

            if (message.equals(LoginConst.LOGIN_FAILED))
            {
                dialog.initAll();
            }
        }

        else if (e.getActionCommand().equals(LoginConst.CLOSE))
        {
            dialog.dispose();
        }
    }
}
