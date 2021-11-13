import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{
    JLabel welcome;

    JButton searchButton;
    JButton borrowOrReserveButton;
    JButton myInfoButton;
    JButton addOrRemoveButton;
    JButton logoutButton;

    String id;

    public MainScreen(MainFrame mf)
    {
        this.setLayout(null);

        welcome = new JLabel();
        welcome.setFont(new Font("맑은고딕", Font.BOLD, 14));

        searchButton = new JButton("도서 검색");
        searchButton.setBounds(130, 150, 150, 40);
        searchButton.addActionListener(e ->
        {
            if (!Window.isWindowOn)
            {
                new SearchWindow(mf);
            }
        });
        add(searchButton);

        borrowOrReserveButton = new JButton("도서 대출/예약");
        borrowOrReserveButton.setBounds(130, 270, 150, 40);
        add(borrowOrReserveButton);

        myInfoButton = new JButton("내 도서 정보");
        myInfoButton.setBounds(380, 270, 150, 40);
        myInfoButton.addActionListener(e ->
        {
            if (!Window.isWindowOn)
            {
                new MyInfoWindow(mf);
            }
        });
        add(myInfoButton);

        addOrRemoveButton = new JButton("도서 추가/삭제");
        addOrRemoveButton.setBounds(380, 390, 150, 40);
        add(addOrRemoveButton);

        logoutButton = new JButton("로그아웃");
        logoutButton.setBounds(550, 700, 120, 40);
        logoutButton.addActionListener(e ->
        {
            if (!Window.isWindowOn)
            {
                new LogoutWindow(mf);
            }
        });
        add(logoutButton);
    }

    public void setId(String id)
    {
        this.id = id;
        welcome.setText(id + "님 환영합니다.");
        welcome.setBounds(600 - (id.length() * 17), 0, (id.length() * 50), 40);
        add(welcome);
    }
}
