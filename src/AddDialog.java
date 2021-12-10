import javax.swing.*;
import java.awt.*;

public class AddDialog extends Dialog
{
    private JLabel isbnLabel;
    private JTextField isbnField;

    private JLabel titleLabel;
    private JTextField titleField;

    private JLabel authorLabel;
    private JTextField authorField;

    private JLabel publisherLabel;
    private JTextField publisherField;

    private JLabel publishDateLabel;
    private JTextField publishYearField;
    private JTextField publishMonthField;
    private JTextField publishDateField;

    private JLabel registerDateLabel;
    private JTextField registerYearField;
    private JTextField registerMonthField;
    private JTextField registerDateField;

    private JButton addButton;
    private JButton closeButton;

    public AddDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(300, 320);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        Font font = new Font("맑은고딕", Font.PLAIN, 14);

        isbnLabel = new JLabel(Const.ISBN);
        isbnLabel.setFont(font);
        isbnLabel.setBounds(47, 10, 60, 30);
        add(isbnLabel);
        isbnField = new JTextField(15);
        isbnField.setBounds(100, 10, 130, 30);
        add(isbnField);

        titleLabel = new JLabel(Const.TITLE);
        titleLabel.setFont(font);
        titleLabel.setBounds(47, 45, 60, 30);
        add(titleLabel);
        titleField = new JTextField(15);
        titleField.setBounds(100, 45, 130, 30);
        add(titleField);

        authorLabel = new JLabel(Const.AUTHOR);
        authorLabel.setFont(font);
        authorLabel.setBounds(47, 80, 60, 30);
        add(authorLabel);
        authorField = new JTextField(15);
        authorField.setBounds(100, 80, 130, 30);
        add(authorField);

        publisherLabel = new JLabel(Const.PUBLISHER);
        publisherLabel.setFont(font);
        publisherLabel.setBounds(40, 115, 60 ,30);
        add(publisherLabel);
        publisherField = new JTextField(15);
        publisherField.setBounds(100, 115, 130, 30);
        add(publisherField);

        publishDateLabel = new JLabel(Const.PUBLISH_DATE);
        publishDateLabel.setFont(font);
        publishDateLabel.setBounds(40, 150, 60, 30);
        add(publishDateLabel);
        publishYearField = new JTextField(6);
        publishYearField.setBounds(100, 150,60, 30);
        add(publishYearField);
        publishMonthField = new JTextField(3);
        publishMonthField.setBounds(165, 150, 30, 30);
        add(publishMonthField);
        publishDateField = new JTextField(3);
        publishDateField.setBounds(200, 150, 30, 30);
        add(publishDateField);


        registerDateLabel = new JLabel(Const.REGISTER_DATE);
        registerDateLabel.setFont(font);
        registerDateLabel.setBounds(40, 185, 60 ,30);
        add(registerDateLabel);
        registerYearField = new JTextField(6);
        registerYearField.setBounds(100, 185,60, 30);
        add(registerYearField);
        registerMonthField = new JTextField(3);
        registerMonthField.setBounds(165, 185, 30, 30);
        add(registerMonthField);
        registerDateField = new JTextField(3);
        registerDateField.setBounds(200, 185, 30, 30);
        add(registerDateField);

        addButton = new JButton(Const.ADD);
        addButton.setBounds(68, 230, 70, 30);
        addButton.addActionListener(listener);
        add(addButton);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(154, 230, 70, 30);
        closeButton.addActionListener(listener);
        add(closeButton);

        setResizable(false);
        setVisible(true);
    }

    public String getIsbn()
    {
        return isbnField.getText();
    }

    public String getTitle()
    {
        return titleField.getText();
    }

    public String getAuthor()
    {
        return authorField.getText();
    }

    public String getPublisher()
    {
        return publisherField.getText();
    }

    public String getPublishDate()
    {
        return publishYearField.getText() + "." + publishMonthField.getText() + "." + publishDateField.getText();
    }

    public String getRegisterDate()
    {
        return registerYearField.getText() + "." + registerMonthField.getText() + "." + registerDateField.getText();
    }

    public boolean isAllFormFilledOut()
    {
        boolean ret = true;
        if (isbnField.getText().equals("") || titleField.getText().equals("")
        || authorField.getText().equals("") || publisherField.getText().equals("")
        || publishYearField.getText().equals("") || publishMonthField.getText().equals("")
        || publishDateField.getText().equals("") || registerYearField.getText().equals("")
        || registerMonthField.getText().equals("") || registerDateField.getText().equals(""))
        {
            ret = false;
        }
        return ret;
    }

    public void initAllForm()
    {
        isbnField.setText("");
        titleField.setText("");
        authorField.setText("");
        publisherField.setText("");
        publishYearField.setText("");
        publishMonthField.setText("");
        publishDateField.setText("");
        registerYearField.setText("");
        registerMonthField.setText("");
        registerDateField.setText("");
    }
}
