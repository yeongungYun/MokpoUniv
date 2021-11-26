public class ReserveCancelDialog extends InputBidDialog
{
    ReserveCancelListener listener;
    public ReserveCancelDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new ReserveCancelListener(this, mf.getMainScreen().getId());

        yesButton.addActionListener(listener);
        noButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
