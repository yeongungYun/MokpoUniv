import javax.swing.*;
import java.awt.*;

public class InitialScreen extends JPanel
{
    private JButton loginBtn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImagePanel imagePanel;

    public InitialScreen(MainFrame mf)
    {
        setLayout(null);
        imagePanel = new ImagePanel("img/MainImage_temp.png");
        setBackground(Color.LIGHT_GRAY);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(260, 530, 150, 40);
        this.add(loginBtn);
        loginBtn.addActionListener(e -> new LoginDialog(mf));

        signUpBtn = new JButton("회원가입");
        signUpBtn.setBounds(260, 600, 150, 40);
        add(signUpBtn);
        signUpBtn.addActionListener(e -> new SignUpDialog(mf));

        exitBtn = new JButton("종료");
        exitBtn.setBounds(260, 670, 150, 40);
        add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));

        add(imagePanel);
    }
}
