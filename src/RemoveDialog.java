public class RemoveDialog extends InputBidDialog
{
    RemoveListener listener;
    public RemoveDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new RemoveListener(this, mf.getMainScreen().getId());

        yesButton.addActionListener(listener);
        noButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
