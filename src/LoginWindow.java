import javax.swing.*;
import java.awt.*;

public class LoginWindow extends Window
{
    private JLabel idLabel;
    private JLabel idRule;
    private JTextField idInputField;

    private JPasswordField passwordInputField;
    private JLabel passwordRule;
    private JLabel passwordLabel;

    private JButton loginButton;
    private JButton closeButton;

    public LoginWindow(MainFrame mf)
    {
        super("로그인");

        setSize(300, 190);
        setLocationRelativeTo(mf.getComponent());

        idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은고딕", Font.BOLD, 14));
        idLabel.setBounds(40, 20, 80, 25);
        add(idLabel);

        idRule = new JLabel("아이디는 10글자 이하");
        idRule.setFont(new Font("맑은고딕", Font.PLAIN, 9));
        idRule.setBounds(105, 6, 140, 10);
        add(idRule);

        idInputField = new JTextField(10);
        idInputField.setBounds(100, 20, 140, 25);
        add(idInputField);

        //

        passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(new Font("맑은고딕", Font.BOLD, 14));
        passwordLabel.setBounds(30, 60, 80, 25);
        add(passwordLabel);

        passwordRule = new JLabel("비밀번호는 15글자 이하");
        passwordRule.setFont(new Font("맑은고딕", Font.PLAIN, 9));
        passwordRule.setBounds(105, 47, 140, 10);
        add(passwordRule);

        passwordInputField = new JPasswordField(10);
        passwordInputField.setBounds(100, 60, 140, 25);
        add(passwordInputField);

        //

        loginButton = new JButton("로그인");
        loginButton.setBounds(40, 100, 85, 30);
        add(loginButton);
        loginButton.addActionListener(e ->
        {
            String id = idInputField.getText();
            String password = new String(passwordInputField.getPassword());
            if (id.equals(""))
            {
                JOptionPane.showMessageDialog(null, "아이디를 입력하세요",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if (password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if (!mf.getMembersDB().tryLogin(id, password))
                {
                    JOptionPane.showMessageDialog(null, "로그인 실패",
                            "로그인", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    mf.loginSuccess(id);
                    dispose();
                }
            }
        });

        closeButton = new JButton("닫기");
        closeButton.setBounds(150, 100, 85, 30);
        add(closeButton);
        closeButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose();
        });
    }

}
