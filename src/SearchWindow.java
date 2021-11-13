import javax.swing.*;
import java.awt.*;

public class SearchWindow extends Window
{
    JRadioButton titleRadioButton;
    JRadioButton authorRadioButton;
    ButtonGroup radioButtonGroup;
    JTextField searchTextField;
    JButton searchButton;
    JButton resetButton;

    JScrollPane booklistPane;
    JButton closeButton;
    JTable table;
    public SearchWindow(MainFrame mf)
    {
        super("도서 목록");
        setSize(515, 650);
        setLocationRelativeTo(mf.getComponent());

        titleRadioButton = new JRadioButton("제목");
        titleRadioButton.setBounds(20, 7, 50, 45);

        authorRadioButton = new JRadioButton("저자");
        authorRadioButton.setBounds(75, 7, 50, 45);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(titleRadioButton);
        radioButtonGroup.add(authorRadioButton);
        add(titleRadioButton);
        add(authorRadioButton);

        searchTextField = new JTextField(25);
        searchTextField.setBounds(130, 10, 210, 35);
        add(searchTextField);

        searchButton = new JButton("검색");
        searchButton.setFont(new Font("맑은고딕", Font.BOLD, 11));
        searchButton.setBounds(345, 10, 60, 35);
        add(searchButton);

        resetButton = new JButton("초기화");
        resetButton.setFont(new Font("맑은고딕", Font.BOLD, 11));
        resetButton.setBounds(415, 10, 70, 35);
        add(resetButton);

        table = mf.getBooksDB().makeTable();

        booklistPane = new JScrollPane(table); // 인자: 컴포넌트
        booklistPane.setBounds(0, 55, 500, 650);
        add(booklistPane);


        //
//
//        closeButton = new JButton("닫기");
//        closeButton.setBounds(420, 590, 60, 30);
//        closeButton.addActionListener(e ->
//        {
//            Window.isWindowOn = false;
//            dispose();
//        });
//        add(closeButton);
    }
}
