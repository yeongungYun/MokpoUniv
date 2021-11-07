import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame
{
    public static boolean isOn = false; // LoginWindow가 여러 개 뜨지 않기 위해 static 변수 선언
    private JLabel id;
    private JLabel password;
    private JTextField inputID;
    private JTextField inputPW;
    private JButton loginBtn;
    private JButton closeBtn;

    public LoginWindow(Component c)
    {
        isOn = true;
        setSize(300, 200);
        setTitle("로그인");
        setLocationRelativeTo(c);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        id = new JLabel("아이디");
        id.setFont(new Font("맑은고딕", Font.BOLD, 14));
        id.setBounds(30, 20, 80, 25);
        add(id);

        inputID = new JTextField(10);
        inputID.setBounds(100, 20, 140, 25);
        add(inputID);

        password = new JLabel("비밀번호");
        password.setFont(new Font("맑은고딕", Font.BOLD, 14));
        password.setBounds(30, 60, 80, 25);
        add(password);

        inputPW = new JTextField(10);
        inputPW.setBounds(100, 60, 140, 25);
        add(inputPW);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(40, 100, 80, 30);
        add(loginBtn);

        closeBtn = new JButton("닫기");
        closeBtn.setBounds(150, 100, 80, 30);
        add(closeBtn);

        closeBtn.addActionListener(e ->
        {
            isOn = false;
            dispose(); // 해당 창만 종료
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 프레임의 X키를 눌러도 창이 종료되지 않음

    }
}
