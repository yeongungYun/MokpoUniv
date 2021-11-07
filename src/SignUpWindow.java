import javax.swing.*;
import java.awt.*;

public class SignUpWindow extends Window
{
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    private JTextField idInputField;
    private JPasswordField passwordInputField;
    private JPasswordField confirmPasswordInputField;

    private JButton signUpButton;
    private JButton closeButton;

    public SignUpWindow(Component c)
    {
        super();
        setSize(300, 260);
        setLocationRelativeTo(c);

        idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은고딕", Font.BOLD, 13));
        idLabel.setBounds(35, 20, 80, 25);
        add(idLabel);

        idInputField = new JTextField(10);
        idInputField.setBounds(100, 20, 140, 25);
        add(idInputField);

        passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(new Font("맑은고딕", Font.BOLD, 12));
        passwordLabel.setBounds(30, 65, 80, 25);
        add(passwordLabel);

        passwordInputField = new JPasswordField(10);
        passwordInputField.setBounds(100, 65, 140, 25);
        add(passwordInputField);

        confirmPasswordLabel = new JLabel("비밀번호 확인");
        confirmPasswordLabel.setFont(new Font("맑은고딕", Font.BOLD, 11));
        confirmPasswordLabel.setBounds(15, 110, 90, 25);
        add(confirmPasswordLabel);

        confirmPasswordInputField = new JPasswordField(10);
        confirmPasswordInputField.setBounds(100, 110, 140, 25);
        add(confirmPasswordInputField);

        signUpButton = new JButton("회원가입");
        signUpButton.setBounds(40, 170, 85, 30);
        add(signUpButton);

        closeButton = new JButton("닫기");
        closeButton.setBounds(150, 170, 85, 30);
        add(closeButton);
        closeButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose(); // 해당 창만 종료
        });
    }
}
