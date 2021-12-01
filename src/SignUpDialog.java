import javax.swing.*;
import java.awt.*;

public class SignUpDialog extends Dialog
{
    private JLabel idLabel;
    private JLabel idRule;
    private JTextField idInputField;

    private JLabel passwordLabel;
    private JLabel passwordRule;
    private JPasswordField passwordInputField;

    private JLabel againPasswordLabel;
    private JPasswordField againPasswordInputField;

    private JButton signUpButton;
    private JButton closeButton;

    private DialogListener listener;

    public SignUpDialog(MainFrame mf, String title)
    {
        super(mf, title);

        setSize(300, 250);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);

        setModalityType(ModalityType.DOCUMENT_MODAL);

        listener = new DialogListener(this);

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

        againPasswordLabel = new JLabel("비밀번호 확인");
        againPasswordLabel.setFont(new Font("맑은고딕", Font.BOLD, 11));
        againPasswordLabel.setBounds(15, 115, 90, 25);
        add(againPasswordLabel);

        againPasswordInputField = new JPasswordField(12);
        againPasswordInputField.setBounds(100, 115, 145, 25);
        add(againPasswordInputField);

        //

        signUpButton = new JButton(Const.SIGNUP);
        signUpButton.setBounds(40, 160, 85, 30);
        add(signUpButton);
        signUpButton.addActionListener(listener);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(150, 160, 85, 30);
        add(closeButton);
        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }

    public String getId()
    {
        return idInputField.getText();
    }
    public String getPassword()
    {
        return new String(passwordInputField.getPassword());
    }
    public String getAgainPassword()
    {
        return new String(againPasswordInputField.getPassword());
    }

    public void initIdField()
    {
        idInputField.setText("");
    }
    public void initPasswordField()
    {
        passwordInputField.setText("");
    }
    public void initAgainPasswordField()
    {
        againPasswordInputField.setText("");
    }
}
