import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Window extends JFrame
{
    protected static boolean isWindowOn = false;

    public Window()
    {
        isWindowOn = true;
        setTitle("로그인");
        setResizable(false);
        setVisible(true);
        setLayout(null);

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
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
