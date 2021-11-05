import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        setVisible(true);
        setTitle("도서관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setSize(600, 700);
        setResizable(false);
        this.setLayout(null);

        JButton logIn = new JButton("로그인");
        logIn.setBounds(200, 460, 150, 40);
        this.add(logIn);
        JButton signUp = new JButton("회원가입");
        signUp.setBounds(200, 530, 150, 40);
        this.add(signUp);
    }
}
