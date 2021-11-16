import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Window extends JFrame
{
    protected static boolean isWindowOn = false;

    public Window(String title)
    {
        isWindowOn = true;
        setTitle(title);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) // 상단 표시줄의 X를 눌렀을 때 이벤트
            {
                isWindowOn = false;
                dispose();
            }
        });
    }

    protected static boolean getIsWindowOn()
    {
        return isWindowOn;
    }
}
