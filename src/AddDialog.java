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

    public AddDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(300, 300);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        Font font = new Font("맑은고딕", Font.PLAIN, 14);

        isbnLabel = new JLabel("isbn");
        isbnLabel.setFont(font);
        isbnField = new JTextField(15);
        isbnField.setBounds(130, 30, 100, 30);
        add(isbnField);

        titleLabel = new JLabel("제목");
        titleLabel.setFont(font);

        authorLabel = new JLabel("저자");
        authorLabel.setFont(font);

        publisherLabel = new JLabel("출판사");
        publisherLabel.setFont(font);

        publishDateLabel = new JLabel("출판일");
        publishDateLabel.setFont(font);

        setResizable(false);
        setVisible(true);
    }

}
