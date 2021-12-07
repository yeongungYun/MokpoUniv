import javax.swing.*;
import java.awt.*;

public class LogoutDialog extends Dialog
{
    private JLabel checkMessage;
    private JButton logoutButton;
    private JButton closeButton;

    public LogoutDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        checkMessage = new JLabel("로그아웃 하시겠습니까?");
        checkMessage.setFont(new Font("맑은고딕", Font.BOLD, 16));
        checkMessage.setBounds(43, 15, 200, 40);
        add(checkMessage);

        logoutButton = new JButton(Const.LOGOUT);
        logoutButton.setBounds(37, 70, 90, 30);
        logoutButton.addActionListener(listener);
        add(logoutButton);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(137, 70, 90, 30);
        closeButton.addActionListener(listener);
        add(closeButton);

        setResizable(false);
        setVisible(true);
    }
}
