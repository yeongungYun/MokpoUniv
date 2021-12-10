import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialScreenListener implements ActionListener
{
    private MainFrame mainFrame;

    public InitialScreenListener(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case Const.LOGIN :
                new LoginDialog(mainFrame, Const.LOGIN);
                break;

            case Const.SIGNUP :
                new SignUpDialog(mainFrame, Const.SIGNUP);
                break;

            case Const.EXIT :
                System.exit(0);
                break;
        }
    }
}
