import javax.swing.*;
import java.awt.*;

public class LogoutDialog extends JDialog
{
    private JLabel checkMessage;
    private JButton logoutButton;
    private JButton closeButton;
    private LogoutListener listener;

    public LogoutDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        listener = new LogoutListener(mf, this);

        checkMessage = new JLabel("로그아웃 하시겠습니까?");
        checkMessage.setFont(new Font("맑은고딕", Font.BOLD, 16));
        checkMessage.setBounds(43, 15, 200, 40);
        add(checkMessage);

        logoutButton = new JButton(Const.YES);
        logoutButton.setBounds(40, 70, 80, 30);
        logoutButton.addActionListener(listener);
        add(logoutButton);

        closeButton = new JButton(Const.NO);
        closeButton.setBounds(140, 70, 80, 30);
        closeButton.addActionListener(listener);
        add(closeButton);

        setResizable(false);
        setVisible(true);
    }
}
