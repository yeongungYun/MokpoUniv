import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectScreen extends JPanel
{
    private JButton loginBtn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImagePanel imagePanel;
    public ConnectScreen(MainFrame mf)
    {
        setLayout(null);
        imagePanel = new ImagePanel("src/MainImage_temp.png");
        add(imagePanel);
        setBackground(Color.LIGHT_GRAY);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(250, 430, 150, 40);
        this.add(loginBtn);
        loginBtn.addActionListener(e ->
        {
            if (!LoginWindow.isOn)
            {
                new LoginWindow(mf.getComponent());
            }
        });

        signUpBtn = new JButton("회원가입");
        signUpBtn.setBounds(250, 500, 150, 40);
        this.add(signUpBtn);

        exitBtn = new JButton("종료");
        exitBtn.setBounds(250, 570, 150, 40);
        this.add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));
    }
}
