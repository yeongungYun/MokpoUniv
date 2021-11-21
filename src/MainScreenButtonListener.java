import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenButtonListener implements ActionListener
{
    private MainScreen screen;

    public MainScreenButtonListener(MainScreen screen)
    {
        this.screen = screen;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(MainScreenConst.SEARCH))
        {
            BookTable table = screen.getTable();
            String searchText = screen.getText();
            boolean isTitleSelected = screen.isTitleSelected();
            table.searchTable(isTitleSelected, searchText);
        }

        else if (e.getActionCommand().equals(MainScreenConst.RESET))
        {
            BookTable table = screen.getTable();
            table.resetTable();
        }

    }
}
