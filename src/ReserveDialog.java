import javax.swing.*;

public class ReserveDialog extends InputBidDialog
{
    private JButton reserveButton;

    public ReserveDialog(MainFrame mf, String title)
    {
        super(mf, title);

        reserveButton = new JButton(Const.RESERVE);
        reserveButton.setBounds(32, 60, 90, 30);
        reserveButton.addActionListener(listener);
        this.add(reserveButton);

        setResizable(false);
        setVisible(true);
    }
}
