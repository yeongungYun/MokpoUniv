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

    public ConnectScreen(MainFrame mf, MembersDBManager mDBm)
    {
        setLayout(null);
        imagePanel = new ImagePanel("src/MainImage_temp.png");
        setBackground(Color.LIGHT_GRAY);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(250, 530, 150, 40);
        this.add(loginBtn);
        loginBtn.addActionListener(e ->
        {
            if (!Window.getIsWindowOn())
            {
                new LoginWindow(mf.getComponent(), mDBm);
            }
        });

        signUpBtn = new JButton("회원가입");
        signUpBtn.setBounds(250, 600, 150, 40);
        this.add(signUpBtn);
        signUpBtn.addActionListener(e ->
        {
            if (!Window.getIsWindowOn())
            {
                new SignUpWindow(mf.getComponent());
            }
        });

        exitBtn = new JButton("종료");
        exitBtn.setBounds(250, 670, 150, 40);
        this.add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));

        add(imagePanel);
    }
}
