import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButtonListener implements ActionListener
{
    private SignUpDialog dialog;
    public SignUpButtonListener(SignUpDialog dialog)
    {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(SignUpConst.SIGNUP))
        {
            String id = dialog.getId();
            String password = dialog.getPassword();
            String againPassword = dialog.getAgainPassword();

            String message = MembersDatabase.getInstance().signUp(id, password, againPassword);
            JOptionPane.showMessageDialog(null,
                    message,
                    "회원가입", JOptionPane.PLAIN_MESSAGE);

            if (message.equals(SignUpConst.WRONG_ID) ||
                    message.equals(SignUpConst.EXIST_SAME_ID))
            {
                dialog.initIdInput();
                dialog.initPasswordInput();
                dialog.initAgainPasswordInput();
            }
            else if (message.equals(SignUpConst.WRONG_PASSWORD))
            {
                dialog.initPasswordInput();
                dialog.initAgainPasswordInput();
            }
            else if (message.equals(SignUpConst.DIFFERENT_PASSWORD))
            {
                dialog.initAgainPasswordInput();
            }
        }

        else if (e.getActionCommand().equals(SignUpConst.CLOSE))
        {
            dialog.dispose();
        }
    }
}
