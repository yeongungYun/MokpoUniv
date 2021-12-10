import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenListener implements ActionListener
{
    private MainFrame mainFrame;
    private MainScreen screen;

    public MainScreenListener(MainFrame mainFrame, MainScreen screen)
    {
        this.mainFrame = mainFrame;
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case Const.SEARCH:
                BookTable table = screen.getTable();
                String searchText = screen.getSearchBarText();
                if (!searchText.equals(""))
                {
                    table.searchInTable(screen.getSelectedCategory(), searchText);
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
                new BorrowDialog(mainFrame, Const.BORROW);
                break;

            case Const.RETURN:
                new ReturnDialog(mainFrame, Const.RETURN);
                break;

            case Const.RESERVE:
                new ReserveDialog(mainFrame, Const.RESERVE);
                break;

            case Const.RESERVE_CANCEL:
                new ReserveCancelDialog(mainFrame, Const.RESERVE_CANCEL);
                break;

            case Const.ADD:
                new AddDialog(mainFrame, Const.ADD);
                break;

            case Const.REMOVE:
                new RemoveDialog(mainFrame, Const.REMOVE);
                break;

            case Const.LOGOUT:
                new LogoutDialog(mainFrame, Const.LOGOUT);
                break;
        }
    }
}
