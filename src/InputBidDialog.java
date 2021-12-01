import javax.swing.*;
import java.awt.*;

public class InputBidDialog extends Dialog
{
    String id;

    JLabel label;
    JTextField field;

    JButton closeButton;


    public InputBidDialog(MainFrame mf, String title) // 자식 클래스마다 리스너 만들고 setResizable, setVisible만 하면 됨
    {
        super(mf, title);
        this.id = mf.getMainScreen().getId();
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);


        label = new JLabel("책 번호 입력");
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        label.setBounds(60, 20, 90, 30);
        this.add(label);

        field = new JTextField(5);
        field.setBounds(160, 20, 40, 30);
        this.add(field);

        closeButton = new JButton(Const.CLOSE);
        closeButton.setBounds(132, 60, 90, 30);
        this.add(closeButton);

    }

    public int getBid()
    {
        String text = field.getText();
        if (text.equals(""))
        {
            return -1;
        }
        else
        {
            return Integer.parseInt(text);
        }
    }

    public BookTable getTable()
    {
        return mf.getMainScreen().getTable();
    }

    public String getId()
    {
        return id;
    }
}
