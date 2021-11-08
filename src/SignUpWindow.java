import javax.swing.*;
import java.awt.*;

public class SignUpWindow extends Window
{
    private JLabel idLabel;
    private JLabel idRule;
    private JTextField idInputField;

    private JLabel passwordLabel;
    private JLabel passwordRule;
    private JPasswordField passwordInputField;

    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordInputField;

    private JButton signUpButton;
    private JButton closeButton;

    public SignUpWindow(MainFrame mf)
    {
        super("회원가입");
        setSize(300, 250);
        setLocationRelativeTo(mf.getComponent());

        idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은고딕", Font.BOLD, 13));
        idLabel.setBounds(35, 25, 80, 25);
        add(idLabel);

        idRule = new JLabel("아이디는 10글자 이하");
        idRule.setFont(new Font("맑은고딕", Font.PLAIN, 9));
        idRule.setBounds(105, 11, 140, 10);
        add(idRule);

        idInputField = new JTextField(12);
        idInputField.setBounds(100, 25, 145, 25);
        add(idInputField);

        //

        passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(new Font("맑은고딕", Font.BOLD, 12));
        passwordLabel.setBounds(30, 70, 80, 25);
        add(passwordLabel);

        passwordRule = new JLabel("비밀번호는 15글자 이하");
        passwordRule.setFont(new Font("맑은고딕", Font.PLAIN, 9));
        passwordRule.setBounds(105, 56, 140, 10);
        add(passwordRule);

        passwordInputField = new JPasswordField(12);
        passwordInputField.setBounds(100, 70, 145, 25);
        add(passwordInputField);

        //

        confirmPasswordLabel = new JLabel("비밀번호 확인");
        confirmPasswordLabel.setFont(new Font("맑은고딕", Font.BOLD, 11));
        confirmPasswordLabel.setBounds(15, 115, 90, 25);
        add(confirmPasswordLabel);

        confirmPasswordInputField = new JPasswordField(12);
        confirmPasswordInputField.setBounds(100, 115, 145, 25);
        add(confirmPasswordInputField);

        //

        signUpButton = new JButton("회원가입");
        signUpButton.setBounds(40, 160, 85, 30);
        add(signUpButton);
        signUpButton.addActionListener(e ->
        {
            String id = idInputField.getText();
            String password = new String(passwordInputField.getPassword());
            String confirmPassword = new String(confirmPasswordInputField.getPassword());
            if (id.equals(""))
            {
                JOptionPane.showMessageDialog(null, "아이디를 입력하세요",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if (id.length() > 10)
            {
                JOptionPane.showMessageDialog(null, "아이디가 너무 깁니다.",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if (password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if (password.length() > 15)
            {
                JOptionPane.showMessageDialog(null, "비밀번호가 너무 깁니다.",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else if (!password.equals(confirmPassword))
            {
                JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다.",
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, mf.getmembersDB().trySignUp(id, password),
                        "로그인", JOptionPane.ERROR_MESSAGE);
            }
        });

        closeButton = new JButton("닫기");
        closeButton.setBounds(150, 160, 85, 30);
        add(closeButton);
        closeButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose(); // 해당 창만 종료
        });
    }
}
