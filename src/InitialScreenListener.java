import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialScreenListener implements ActionListener
{
    MainFrame mf;

    public InitialScreenListener(MainFrame mf)
    {
        this.mf = mf;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case Const.LOGIN :
                new LoginDialog(mf, Const.LOGIN);
                break;

            case Const.SIGNUP :
                new SignUpDialog(mf, Const.SIGNUP);
                break;

            case Const.EXIT :
                System.exit(0);
                break;
        }
    }
}
