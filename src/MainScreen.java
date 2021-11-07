import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{
    JButton printBooksButton;
    JButton searchBookButton;
    JButton borrowBookButton;
    JButton reserveBookButton;
    JButton returnBookButton;
    JButton myBookInfoButton;
    JButton addOrRemoveBookButton;

    public MainScreen()
    {
        this.setLayout(null);

        printBooksButton = new JButton("도서 리스트 출력");
        printBooksButton.setBounds(140, 150, 150, 40);
        this.add(printBooksButton);

        searchBookButton = new JButton("도서 검색");
        searchBookButton.setBounds(140, 250, 150, 40);
        this.add(searchBookButton);

        borrowBookButton = new JButton("도서 대출");
        borrowBookButton.setBounds(140, 350, 150, 40);
        this.add(borrowBookButton);

        reserveBookButton = new JButton("도서 예약");
        reserveBookButton.setBounds(140, 450, 150, 40);
        this.add(reserveBookButton);

        returnBookButton = new JButton("도서 반납");
        returnBookButton.setBounds(390, 150, 150, 40);
        this.add(returnBookButton);

        myBookInfoButton = new JButton("내 도서 정보");
        myBookInfoButton.setBounds(390, 250, 150, 40);
        this.add(myBookInfoButton);

        addOrRemoveBookButton = new JButton("도서 추가/삭제");
        addOrRemoveBookButton.setBounds(390, 350, 150, 40);
        this.add(addOrRemoveBookButton);
    }
}
