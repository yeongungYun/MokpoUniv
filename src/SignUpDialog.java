import javax.swing.*;
import java.awt.*;

public class SignUpDialog extends Dialog
{
    private JLabel idLabel;
    private JLabel idRule;
    private JTextField idField;

    private JLabel passwordLabel;
    private JLabel passwordRule;
    private JPasswordField passwordField;

    private JLabel againPasswordLabel;
    private JPasswordField againPasswordField;

    private JButton signUpButton;
    private JButton closeButton;

    private JTextField showPasswordField;
    private JTextField showAgainPasswordField;
    private JCheckBox checkbox;

    private DialogListener listener;

    public SignUpDialog(MainFrame mf, String title)
    {
        super(mf, title);

        setSize(300, 260);
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

        idField = new JTextField(12);
        idField.setBounds(100, 25, 145, 25);
        add(idField);

        //

        passwordLabel = new JLabel("비밀번호");
        passwordLabel.setFont(new Font("맑은고딕", Font.BOLD, 12));
        passwordLabel.setBounds(30, 70, 80, 25);
        add(passwordLabel);

        passwordRule = new JLabel("비밀번호는 15글자 이하");
        passwordRule.setFont(new Font("맑은고딕", Font.PLAIN, 9));
        passwordRule.setBounds(105, 56, 140, 10);
        add(passwordRule);

        passwordField = new JPasswordField(12);
        passwordField.setBounds(100, 70, 145, 25);
        add(passwordField);

        showPasswordField = new JTextField(12);
        showPasswordField.setBounds(100, 70, 145, 25);


        //

        againPasswordLabel = new JLabel("비밀번호 확인");
        againPasswordLabel.setFont(new Font("맑은고딕", Font.BOLD, 11));
        againPasswordLabel.setBounds(15, 115, 90, 25);
        add(againPasswordLabel);

        againPasswordField = new JPasswordField(12);
        againPasswordField.setBounds(100, 115, 145, 25);
        add(againPasswordField);

        showAgainPasswordField = new JTextField(12);
        showAgainPasswordField.setBounds(100, 115, 145, 25);

        //

        checkbox = new JCheckBox(Const.SHOW_PASSWORD);
        checkbox.setFont(new Font("맑은고딕", Font.PLAIN, 11));
        checkbox.setBounds(15, 142, 120, 20);
        checkbox.addActionListener(listener);
        add(checkbox);

        signUpButton = new JButton(Const.SIGNUP);
        signUpButton.setBounds(47, 170, 85, 30);
        add(signUpButton);
        signUpButton.addActionListener(listener);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(150, 170, 85, 30);
        add(closeButton);
        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }

    public String getId()
    {
        return idField.getText();
    }
    public String getPassword()
    {
        return new String(passwordField.getPassword());
    }
    public String getAgainPassword()
    {
        return new String(againPasswordField.getPassword());
    }

    public void initIdField()
    {
        idField.setText("");
    }
    public void initPasswordField()
    {
        passwordField.setText("");
    }
    public void initAgainPasswordField()
    {
        againPasswordField.setText("");
    }
    public boolean getCheckbox()
    {
        return checkbox.isSelected();
    }

    public void showPassword()
    {
        showPasswordField.setText(getPassword());
        showAgainPasswordField.setText(getAgainPassword());
        remove(passwordField);
        remove(againPasswordField);
        add(showPasswordField);
        add(showAgainPasswordField);
    }
    public void hidePassword()
    {
        passwordField.setText(showPasswordField.getText());
        againPasswordField.setText(showAgainPasswordField.getText());
        remove(showPasswordField);
        remove(showAgainPasswordField);
        add(passwordField);
        add(againPasswordField);
    }
}
