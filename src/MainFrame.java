import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private CardLayout cards;
    private InitialScreen initialScreen;
    private MainScreen mainScreen;
    private Container container;

    public MainFrame()
    {
        container = getContentPane(); // 컨테이너. CardLayout과 연결
        cards = new CardLayout();
        initialScreen = new InitialScreen(this);
        mainScreen = new MainScreen(this);
        setVisible(true);
        setTitle("도서관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // 화면의 중앙에 창이 뜸
        setResizable(false); // 창 크기 변경 불가
        
        setLayout(cards);
        container.add(initialScreen, "1");
        container.add(mainScreen, "2");
    }
    public Component getComponent() // Dialog의 처음 위치 지정을 위해
    {
        return this;
    }

    public void login(String id)
    {
        cards.next(container);
        mainScreen.setId(id);
    }
    public void logout()
    {
        cards.next(container);
    }

    public MainScreen getMainScreen()
    {
        return mainScreen;
    }
}
