import javax.swing.*;

public class ReturnDialog extends InputBidDialog
{
    private JButton returnButton;

    DialogListener listener;
    public ReturnDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new DialogListener(this);

        returnButton = new JButton(Const.RETURN);
        returnButton.setBounds(32, 60, 90, 30);
        returnButton.addActionListener(listener);
        this.add(returnButton);

        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
