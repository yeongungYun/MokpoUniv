import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
    private CardLayout cards;
    private LoginScreen loginScreen;
    private MainScreen mainScreen;
    private Container container;

    public MainFrame()
    {
        container = getContentPane();
        cards = new CardLayout();
        loginScreen = new LoginScreen(this);
        mainScreen = new MainScreen();
        setVisible(true);
        setTitle("도서관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setResizable(false);
        setLayout(cards);
        container.add(loginScreen, "1");
        container.add(mainScreen, "2");
    }

    public CardLayout getCards()
    {
        return cards;
    }
    public Container getContainer()
    {
        return container;
    }
}
