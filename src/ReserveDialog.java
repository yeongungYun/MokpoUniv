import javax.swing.*;

public class ReserveDialog extends InputBidDialog
{
    private JButton reserveButton;

    public ReserveDialog(MainFrame mainFrame, String title)
    {
        super(mainFrame, title);

        reserveButton = new JButton(Const.RESERVE);
        reserveButton.setBounds(32, 60, 90, 30);
        reserveButton.addActionListener(listener);
        this.add(reserveButton);

        setResizable(false);
        setVisible(true);
    }
}
