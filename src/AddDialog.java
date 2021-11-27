import javax.swing.*;
import java.awt.*;

public class AddDialog extends JDialog
{
    JLabel isbnLabel;
    JTextField isbnField;

    JLabel titleLabel;
    JTextField titleField;

    JLabel authorLabel;
    JTextField authorField;

    JLabel publisherLabel;
    JTextField publisherField;

    JLabel publishDateLabel;
    JTextField publishDateField;

    JButton addButton;
    JButton closeButton;

    AddListener listener;

    BookTable table;

    public AddDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(300, 280);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        listener = new AddListener(this);

        Font font = new Font("맑은고딕", Font.PLAIN, 14);

        isbnLabel = new JLabel("isbn");
        isbnLabel.setFont(font);
        isbnLabel.setBounds(70, 10, 60, 30);
        add(isbnLabel);
        isbnField = new JTextField(15);
        isbnField.setBounds(120, 10, 100, 30);
        add(isbnField);

        titleLabel = new JLabel("제목");
        titleLabel.setFont(font);
        titleLabel.setBounds(70, 45, 60, 30);
        add(titleLabel);
        titleField = new JTextField(15);
        titleField.setBounds(120, 45, 100, 30);
        add(titleField);

        authorLabel = new JLabel("저자");
        authorLabel.setFont(font);
        authorLabel.setBounds(70, 80, 60, 30);
        add(authorLabel);
        authorField = new JTextField(15);
        authorField.setBounds(120, 80, 100, 30);
        add(authorField);

        publisherLabel = new JLabel("출판사");
        publisherLabel.setFont(font);
        publisherLabel.setBounds(60, 115, 60 ,30);
        add(publisherLabel);
        publisherField = new JTextField(15);
        publisherField.setBounds(120, 115, 100, 30);
        add(publisherField);

        publishDateLabel = new JLabel("출판일");
        publishDateLabel.setFont(font);
        publishDateLabel.setBounds(60, 150, 60, 30);
        add(publishDateLabel);
        publishDateField = new JTextField(15);
        publishDateField.setBounds(120, 150,100, 30);
        add(publishDateField);

        addButton = new JButton(Const.ADD);
        addButton.setBounds(55, 190, 70, 30);
        addButton.addActionListener(listener);
        add(addButton);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(150, 190, 70, 30);
        closeButton.addActionListener(listener);
        add(closeButton);

        table = mf.getMainScreen().getTable();

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
        return publishDateField.getText();
    }

    public BookTable getTable()
    {
        return table;
    }
}
