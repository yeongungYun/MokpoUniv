import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpListener implements ActionListener
{
    private SignUpDialog dialog;
    public SignUpListener(SignUpDialog dialog)
    {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(Const.SIGNUP))
        {
            String id = dialog.getId();
            String password = dialog.getPassword();
            String againPassword = dialog.getAgainPassword();

            String message = MembersDatabase.getInstance().signUp(id, password, againPassword);
            JOptionPane.showMessageDialog(null,
                    message,
                    "회원가입", JOptionPane.PLAIN_MESSAGE);

            if (message.equals(Const.WRONG_ID) ||
                    message.equals(Const.EXIST_SAME_ID))
            {
                dialog.initIdInput();
                dialog.initPasswordInput();
                dialog.initAgainPasswordInput();
            }
            else if (message.equals(Const.WRONG_PASSWORD))
            {
                dialog.initPasswordInput();
                dialog.initAgainPasswordInput();
            }
            else if (message.equals(Const.DIFFERENT_PASSWORD))
            {
                dialog.initAgainPasswordInput();
            }
        }

        else if (e.getActionCommand().equals(Const.CLOSE))
        {
            dialog.dispose();
        }
    }
}
