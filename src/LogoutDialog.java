import javax.swing.*;
import java.awt.*;

public class LogoutDialog extends JDialog
{
    private JLabel checkMessage;
    private JButton logoutButton;
    private JButton closeButton;

    public LogoutDialog(MainFrame mf)
    {
        super(mf, "로그아웃");
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        checkMessage = new JLabel("로그아웃 하시겠습니까?");
        checkMessage.setFont(new Font("맑은고딕", Font.BOLD, 16));
        checkMessage.setBounds(43, 15, 200, 40);
        add(checkMessage);

        logoutButton = new JButton("예");
        logoutButton.setBounds(40, 70, 80, 30);
        logoutButton.addActionListener(e ->
        {
            dispose();
            mf.changeScreen();
        });
        add(logoutButton);

        closeButton = new JButton("아니오");
        closeButton.setBounds(140, 70, 80, 30);
        closeButton.addActionListener(e -> dispose());
        add(closeButton);

        setResizable(false);
        setVisible(true);
    }
}
