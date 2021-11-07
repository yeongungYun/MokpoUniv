import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    protected static boolean isWindowOn = false;

    public Window()
    {
        setTitle("로그인");
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 프레임의 X키를 눌러도 창이 종료되지 않음
    }

    protected static boolean getIsWindowOn()
    {
        return isWindowOn;
    }
}
