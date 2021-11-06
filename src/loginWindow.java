import javax.swing.*;
import java.awt.*;

public class loginWindow extends JFrame
{
    JLabel id;
    JLabel password;
    JTextField inputID;
    JTextField inputPW;

    public loginWindow(Component c)
    {
        setSize(300, 300);
        setTitle("로그인");
        setLocationRelativeTo(c);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        id = new JLabel("아이디");
        id.setFont(new Font("D2Coding", Font.BOLD, 20));
        id.setBounds(20, 20, 80, 100);
        this.add(id);

        inputID = new JTextField(10);
        inputID.setBounds(90, 60, 100, 25);
        this.add(inputID);

        password = new JLabel("비밀번호");
        this.add(password);

        inputPW = new JTextField(10);
        this.add(inputPW);
    }
}
