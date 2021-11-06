import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel
{
    private JButton loginBtn;
    private JButton signUpBtn;
    private JButton exitBtn;
    private ImagePanel imagePanel;
    private Component c;
    public LoginScreen(MainFrame mf)
    {
        c = mf.getComponent();
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        imagePanel = new ImagePanel();
        this.add(imagePanel);


        loginBtn = new JButton("로그인");
        loginBtn.setBounds(250, 430, 150, 40);
        this.add(loginBtn);
        loginBtn.addActionListener(e -> new loginWindow(c));

        signUpBtn = new JButton("회원가입");
        signUpBtn.setBounds(250, 500, 150, 40);
        this.add(signUpBtn);

        exitBtn = new JButton("종료");
        exitBtn.setBounds(250, 570, 150, 40);
        this.add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));
    }
}
