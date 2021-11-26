import javax.swing.*;
import java.awt.*;

public class InputBookNumberDialog extends JDialog
{
    JLabel label;
    JTextField field;

    JButton yesButton;
    JButton noButton;
    public InputBookNumberDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        label = new JLabel("책 번호 입력");
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        label.setBounds(60, 20, 80, 30);
        this.add(label);

        field = new JTextField(5);
        field.setBounds(155, 20, 40, 30);
        this.add(field);

        yesButton = new JButton(Const.YES);
        yesButton.setBounds(52, 60, 70, 30);
        this.add(yesButton);

        noButton = new JButton(Const.NO);
        noButton.setBounds(142, 60, 70, 30);
        this.add(noButton);

        setResizable(false);
        setVisible(true);
    }
}
