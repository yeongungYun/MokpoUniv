import javax.swing.*;

public class ReturnDialog extends InputBidDialog
{
    private JButton returnButton;

    public ReturnDialog(MainFrame mf, String title)
    {
        super(mf, title);

        returnButton = new JButton(Const.RETURN);
        returnButton.setBounds(32, 60, 90, 30);
        returnButton.addActionListener(listener);
        this.add(returnButton);

        setResizable(false);
        setVisible(true);
    }
}
