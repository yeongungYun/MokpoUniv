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
        switch (e.getActionCommand())
        {
            case Const.SEARCH:
                BookTable table = screen.getTable();
                String searchText = screen.getText();
                if (!searchText.equals(""))
                {
                    table.searchTable(screen.getSelectedCategory(), searchText);
                }
                break;

            case Const.RESET:
                screen.getTable().resetTable();
                break;

            case Const.MY_INFORMATION:
                String id = screen.getId();
                screen.getTable().searchMyInfo(id);
                break;

            case Const.BORROW:
                new BorrowDialog(mf, Const.BORROW);
                break;

            case Const.RETURN:
                new ReturnDialog(mf, Const.RETURN);
                break;

            case Const.RESERVE:
                new ReserveDialog(mf, Const.RESERVE);
                break;

            case Const.RESERVE_CANCEL:
                new ReserveCancelDialog(mf, Const.RESERVE_CANCEL);
                break;

            case Const.ADD:
                new AddDialog(mf, Const.ADD);
                break;

            case Const.REMOVE:
                new RemoveDialog(mf, Const.REMOVE);
                break;

            case Const.LOGOUT:
                new LogoutDialog(mf, Const.LOGOUT);
                break;
        }
    }
}
