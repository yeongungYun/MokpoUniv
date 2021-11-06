import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{
    JButton printBooksBtn;
    JButton searchBookBtn;
    JButton borrowBookBtn;
    JButton reserveBookBtn;
    JButton returnBookBtn;
    JButton myBookInfoBtn;
    JButton addOrRemoveBookBtn;

    public MainScreen()
    {
        this.setLayout(null);

        printBooksBtn = new JButton("도서 리스트 출력");
        printBooksBtn.setBounds(140, 150, 150, 40);
        this.add(printBooksBtn);

        searchBookBtn = new JButton("도서 검색");
        searchBookBtn.setBounds(140, 250, 150, 40);
        this.add(searchBookBtn);

        borrowBookBtn = new JButton("도서 대출");
        borrowBookBtn.setBounds(140, 350, 150, 40);
        this.add(borrowBookBtn);

        reserveBookBtn = new JButton("도서 예약");
        reserveBookBtn.setBounds(140, 450, 150, 40);
        this.add(reserveBookBtn);

        returnBookBtn = new JButton("도서 반납");
        returnBookBtn.setBounds(390, 150, 150, 40);
        this.add(returnBookBtn);

        myBookInfoBtn = new JButton("내 도서 정보");
        myBookInfoBtn.setBounds(390, 250, 150, 40);
        this.add(myBookInfoBtn);

        addOrRemoveBookBtn = new JButton("도서 추가/삭제");
        addOrRemoveBookBtn.setBounds(390, 350, 150, 40);
        this.add(addOrRemoveBookBtn);
    }
}
