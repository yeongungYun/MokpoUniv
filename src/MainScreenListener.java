import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenListener implements ActionListener
{
    private MainFrame mf;
    private MainScreen screen;

    public MainScreenListener(MainFrame mf, MainScreen screen)
    {
        this.mf = mf;
        this.screen = screen;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(Const.SEARCH))
        {
            BookTable table = screen.getTable();
            String searchText = screen.getText();
            boolean isTitleSelected = screen.isTitleSelected();
            if (!searchText.equals(""))
            {
                table.searchTable(isTitleSelected, searchText);
            }
        }

        else if (e.getActionCommand().equals(Const.RESET))
        {
            screen.getTable().resetTable();
        }
        else if (e.getActionCommand().equals(Const.MY_INFORMATION))
        {
            String id = screen.getId();
            screen.getTable().searchMyInfo(id);
        }
        else if (e.getActionCommand().equals(Const.BORROW))
        {
            new BorrowDialog(mf, Const.BORROW);
        }

        else if (e.getActionCommand().equals(Const.RETURN))
        {
            new ReturnDialog(mf, Const.RETURN);
        }

        else if (e.getActionCommand().equals(Const.RESERVE))
        {
            new ReserveDialog(mf, Const.RESERVE);
        }

        else if (e.getActionCommand().equals(Const.RESERVE_CANCEL))
        {
            new ReserveCancelDialog(mf, Const.RESERVE_CANCEL);
        }

        else if (e.getActionCommand().equals(Const.ADD))
        {
            new AddDialog(mf, Const.ADD);
        }

        else if (e.getActionCommand().equals(Const.REMOVE))
        {
            new RemoveDialog(mf, Const.REMOVE);
        }

        else if (e.getActionCommand().equals(Const.LOGOUT))
        {
            new LogoutDialog(mf, Const.LOGOUT);
        }
    }
}
