import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{
    JLabel welcome;

    JButton printBooksButton;
    JButton searchBookButton;
    JButton borrowBookButton;
    JButton reserveBookButton;
    JButton returnBookButton;
    JButton myBookInfoButton;
    JButton addOrRemoveBookButton;
    JButton logoutButton;

    String id;

    public MainScreen()
    {
        this.setLayout(null);

        welcome = new JLabel();
        welcome.setFont(new Font("맑은고딕", Font.BOLD, 14));

        printBooksButton = new JButton("도서 리스트 출력");
        printBooksButton.setBounds(130, 150, 150, 40);
        add(printBooksButton);

        searchBookButton = new JButton("도서 검색");
        searchBookButton.setBounds(130, 270, 150, 40);
        add(searchBookButton);

        borrowBookButton = new JButton("도서 대출");
        borrowBookButton.setBounds(130, 390, 150, 40);
        add(borrowBookButton);

        reserveBookButton = new JButton("도서 예약");
        reserveBookButton.setBounds(130, 510, 150, 40);
        add(reserveBookButton);

        returnBookButton = new JButton("도서 반납");
        returnBookButton.setBounds(380, 150, 150, 40);
        add(returnBookButton);

        myBookInfoButton = new JButton("내 도서 정보");
        myBookInfoButton.setBounds(380, 270, 150, 40);
        add(myBookInfoButton);

        addOrRemoveBookButton = new JButton("도서 추가/삭제");
        addOrRemoveBookButton.setBounds(380, 390, 150, 40);
        add(addOrRemoveBookButton);

        logoutButton = new JButton("로그아웃");
        logoutButton.setBounds(580, 710, 90, 40);
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
