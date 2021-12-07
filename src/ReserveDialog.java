import javax.swing.*;

public class ReserveDialog extends InputBidDialog
{
    private JButton reserveButton;

    DialogListener listener;
    public ReserveDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new DialogListener(this);

        reserveButton = new JButton(Const.RESERVE);
        reserveButton.setBounds(32, 60, 90, 30);
        reserveButton.addActionListener(listener);
        this.add(reserveButton);

        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
