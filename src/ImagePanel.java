import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagePanel extends JPanel
{
    Image image;
    public ImagePanel(String imageAddr)
    {
        this.setBounds(0, 0, 700, 800);
        try
        {
            image = ImageIO.read(new File(imageAddr));
            image = image.getScaledInstance(700, 800, Image.SCALE_SMOOTH);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
    }
}
