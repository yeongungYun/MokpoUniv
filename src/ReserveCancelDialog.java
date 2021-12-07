import javax.swing.*;
import java.awt.*;

public class ReserveCancelDialog extends InputBidDialog
{
    private JButton reverseCancelButton;

    DialogListener listener;
    public ReserveCancelDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new DialogListener(this);

        reverseCancelButton = new JButton(Const.RESERVE_CANCEL);
        reverseCancelButton.setBounds(32, 60, 90, 30);
        reverseCancelButton.setFont(new Font("맑은고딕", Font.BOLD, 10));
        reverseCancelButton.addActionListener(listener);
        this.add(reverseCancelButton);

        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
