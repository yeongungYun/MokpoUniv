import javax.swing.*;

public class ReturnDialog extends InputBidDialog
{
    private JButton returnButton;

    public ReturnDialog(MainFrame mainFrame, String title)
    {
        super(mainFrame, title);

        returnButton = new JButton(Const.RETURN);
        returnButton.setBounds(32, 60, 90, 30);
        returnButton.addActionListener(listener);
        this.add(returnButton);

        setResizable(false);
        setVisible(true);
    }
}
