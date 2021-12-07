import javax.swing.*;

public class Dialog extends JDialog
{
    protected MainFrame mf;
    protected DialogListener listener;
    public Dialog(MainFrame mf, String title)
    {
        super(mf, title);
        this.mf = mf;
        listener = new DialogListener(this);
    }

    public MainFrame getMainFrame()
    {
        return mf;
    }
}
