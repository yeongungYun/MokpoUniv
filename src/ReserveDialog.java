public class ReserveDialog extends InputBidDialog
{
    ReserveListener listener;
    public ReserveDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new ReserveListener(this, mf.getMainScreen().getId());

        yesButton.addActionListener(listener);
        noButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
