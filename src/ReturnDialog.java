import javax.swing.*;

public class ReturnDialog extends InputBidDialog
{
    ReturnListener listener;
    public ReturnDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new ReturnListener(this, mf.getMainScreen().getId());

        yesButton.addActionListener(listener);
        noButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
