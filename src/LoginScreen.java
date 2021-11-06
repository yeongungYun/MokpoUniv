import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel
{
    private JButton login;
    private JButton signUp;
    private JButton exit;
    private ImagePanel imagePanel;
    public LoginScreen(MainFrame mf)
    {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        imagePanel = new ImagePanel();
        this.add(imagePanel);

        login = new JButton("로그인");
        login.setBounds(250, 430, 150, 40);
        this.add(login);
        login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cd = mf.getCards();
                cd.next(mf.getContainer());
            }
        });

        signUp = new JButton("회원가입");
        signUp.setBounds(250, 500, 150, 40);
        this.add(signUp);

        exit = new JButton("종료");
        exit.setBounds(250, 570, 150, 40);
        this.add(exit);
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
}
