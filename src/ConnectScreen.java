import javax.swing.*;
import java.awt.*;

public class ConnectScreen extends JPanel
{
    private JButton loginBtn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImagePanel imagePanel;

    public ConnectScreen(MainFrame mf)
    {
        setLayout(null);
        imagePanel = new ImagePanel("img/MainImage_temp.png");
        setBackground(Color.LIGHT_GRAY);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(250, 530, 150, 40);
        this.add(loginBtn);
        loginBtn.addActionListener(e ->
        {
            if (!Window.getIsWindowOn())
            {
                new LoginWindow(mf);
            }
        });

        signUpBtn = new JButton("회원가입");
        signUpBtn.setBounds(250, 600, 150, 40);
        this.add(signUpBtn);
        signUpBtn.addActionListener(e ->
        {
            if (!Window.getIsWindowOn())
            {
                new SignUpWindow(mf);
            }
        });

        exitBtn = new JButton("종료");
        exitBtn.setBounds(250, 670, 150, 40);
        this.add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));

        add(imagePanel);
    }
}
