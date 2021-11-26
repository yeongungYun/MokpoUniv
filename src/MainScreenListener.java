import javax.swing.*;
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
            BookListPanel table = screen.getTablePanel();
            String searchText = screen.getText();
            boolean isTitleSelected = screen.isTitleSelected();
            if (!searchText.equals(""))
            {
                table.searchTable(isTitleSelected, searchText);
            }
        }

        else if (e.getActionCommand().equals(Const.RESET))
        {
            BookListPanel table = screen.getTablePanel();
            table.resetTable();
        }
        else if (e.getActionCommand().equals(Const.MY_INFORMATION))
        {
            String id = screen.getId();
            BookListPanel table = screen.getTablePanel();
            table.searchMyInfo(id);
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

        else if (e.getActionCommand().equals(Const.LOGOUT))
        {
            new LogoutDialog(mf, Const.LOGOUT);
        }
    }
}
