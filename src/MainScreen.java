import javax.swing.*;

public class MainScreen extends JPanel
{
    BookTable bookTable;

    JButton logoutButton;
    public MainScreen(MainFrame mf)
    {
        this.setLayout(null);
        bookTable = new BookTable(mf);
        bookTable.setBounds(10, 60, 540, 710);
        add(bookTable);

        logoutButton = new JButton("로그아웃");
        logoutButton.setBounds(565, 720, 100, 30);
        logoutButton.addActionListener(e ->
        {
            if (!Window.isWindowOn)
            {
                new LogoutWindow(mf);
            }
        });
        add(logoutButton);
    }
}
