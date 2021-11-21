import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private CardLayout cards;
    private InitialScreen initialScreen;
    private MainScreen mainScreen;
    private Container container;
    private Component c;

    public MainFrame()
    {
        c = this; // Dialog의 처음 위치 지정을 위해
        container = getContentPane(); // 컨테이너. CardLayout과 연결
        cards = new CardLayout();
        initialScreen = new InitialScreen(this);
        mainScreen = new MainScreen(this);

        setVisible(true);
        setTitle("도서관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setLocationRelativeTo(null); // 화면의 중앙에 창이 뜸
        setResizable(false); // 창 크기 변경 불가
        
        setLayout(cards);
        container.add(initialScreen, "1");
        container.add(mainScreen, "2");
    }
    public Component getComponent()
    {
        return c;
    }

    public void changeScreen() // 로그인 성공 / 로그이웃 시 스크린 교체
    {
        cards.next(container);
    }
}
