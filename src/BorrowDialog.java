public class BorrowDialog extends InputBidDialog
{
    BorrowListener listener;
    public BorrowDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new BorrowListener(this, mf.getMainScreen().getId());

        yesButton.addActionListener(listener);
        noButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
