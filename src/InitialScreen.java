import javax.swing.*;
import java.awt.*;

public class InitialScreen extends JPanel
{
    private JButton loginButton;
    private JButton signUpButton;
    private JButton exitButton;
    private ImagePanel imagePanel;


    private InitialScreenListener listener;
    public InitialScreen(MainFrame mf)
    {
        setLayout(null);
        imagePanel = new ImagePanel("img/MainImage_temp.png");
        setBackground(Color.LIGHT_GRAY);

        listener = new InitialScreenListener(mf);

        Font font = new Font("맑은고딕", Font.BOLD, 18);

        loginButton = new JButton(Const.LOGIN);
        loginButton.setBounds(290, 500, 200, 50);
        loginButton.setFont(font);
        this.add(loginButton);
        loginButton.addActionListener(listener);

        signUpButton = new JButton(Const.SIGNUP);
        signUpButton.setBounds(290, 580, 200, 50);
        signUpButton.setFont(font);
        add(signUpButton);
        signUpButton.addActionListener(listener);

        exitButton = new JButton(Const.EXIT);
        exitButton.setBounds(290, 660, 200, 50);
        exitButton.setFont(font);
        add(exitButton);
        exitButton.addActionListener(listener);

        add(imagePanel);
    }
}
