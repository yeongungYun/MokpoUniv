import javax.swing.*;

public class Dialog extends JDialog
{
    protected MainFrame mainFrame;
    protected DialogListener listener;
    public Dialog(MainFrame mainFrame, String title)
    {
        super(mainFrame, title);
        this.mainFrame = mainFrame;
        listener = new DialogListener(this);
    }

    public MainFrame getMainFrame()
    {
        return mainFrame;
    }
}
