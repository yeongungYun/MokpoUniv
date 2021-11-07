import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private CardLayout cards;
    private ConnectScreen connectScreen;
    private MainScreen mainScreen;
    private Container container;
    private Component c;

    public MainFrame()
    {
        c = this; // 컴포넌트. 다른 Window창들의 setLocationRelativeTo를 위해 존재함
        container = getContentPane(); // 컨테이너. CardLayout과 연결
        cards = new CardLayout();
        connectScreen = new ConnectScreen(this);
        mainScreen = new MainScreen();

        setVisible(true);
        setTitle("도서관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null); // 화면의 중앙에 창이 뜸
        setResizable(false); // 창 크기 변경 불가
        
        setLayout(cards);
        container.add(connectScreen, "1");
        container.add(mainScreen, "2");
    }
    public Component getComponent()
    {
        return c;
    }
}
