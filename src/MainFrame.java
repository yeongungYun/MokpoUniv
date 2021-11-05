import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        setTitle("도서 관리 시스템");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}
