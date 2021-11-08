import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends Window
{
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField idInputField;
    private JPasswordField passwordInputField;
    private JButton loginButton;
    private JButton closeButton;

    public LoginWindow(Component c, MembersDBManager mDBm)
    {
        super();
        setSize(300, 190);
        setLocationRelativeTo(c);

        idLabel = new JLabel("아이디");
        idLabel.setFont(new Font("맑은고딕", Font.BOLD, 14));
        idLabel.setBounds(40, 20, 80, 25);
        add(idLabel);

        idInputField = new JTextField(10);
        idInputField.setBounds(100, 20, 140, 25);
        add(idInputField);

        passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(new Font("맑은고딕", Font.BOLD, 14));
        passwordLabel.setBounds(30, 60, 80, 25);
        add(passwordLabel);

        passwordInputField = new JPasswordField(10);
        passwordInputField.setBounds(100, 60, 140, 25);
        add(passwordInputField);

        loginButton = new JButton("로그인");
        loginButton.setBounds(40, 100, 85, 30);
        add(loginButton);
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id = idInputField.getText();
                String password = new String(passwordInputField.getPassword());
                JOptionPane.showMessageDialog(null, mDBm.leaveLoginMessage(id, password), "로그인", JOptionPane.ERROR_MESSAGE);
            }
        });

//      JOptionPane.showMessageDialog(null, text, "아이디", JOptionPane.ERROR_MESSAGE);


        closeButton = new JButton("닫기");
        closeButton.setBounds(150, 100, 85, 30);
        add(closeButton);
        closeButton.addActionListener(e ->
        {
            Window.isWindowOn = false;
            dispose(); // 해당 창만 종료
        });
    }

}
