import javax.swing.*;

public class Dialog extends JDialog
{
    protected MainFrame mf;
    public Dialog(MainFrame mf, String title)
    {
        super(mf, title);
        this.mf = mf;
    }

    public MainFrame getMainFrame()
    {
        return mf;
    }
}
