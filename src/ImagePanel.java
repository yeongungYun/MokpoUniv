import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagePanel extends JPanel
{
    Image mainImage;
    public ImagePanel(String imageAddr)
    {
        this.setBounds(0, 0, 700, 800);
        try
        {
            mainImage = ImageIO.read(new File(imageAddr));
            mainImage = mainImage.getScaledInstance(700, 800, Image.SCALE_SMOOTH);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(mainImage, 0, 0, null);
    }
}
