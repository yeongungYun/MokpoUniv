import javax.swing.*;

public class LogoutWindow extends Window
{
    JLabel checkMessage;
    JButton logoutButton;
    JButton closeButton;

    public LogoutWindow(MainFrame mf)
    {
        super("로그아웃");
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());

        checkMessage = new JLabel("로그아웃 하시겠습니까?");
        checkMessage.setBounds(60, 20, 150, 40);
        add(checkMessage);

        logoutButton = new JButton("예");
        logoutButton.setBounds(40, 70, 80, 30);
        logoutButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose();
            mf.logout();
        });
        add(logoutButton);

        closeButton = new JButton("아니오");
        closeButton.setBounds(140, 70, 80, 30);
        closeButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose();
        });

        add(closeButton);

    }
}
