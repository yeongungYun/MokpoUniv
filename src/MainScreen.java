import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{

    private JPanel searchPanel;
    private JRadioButton titleRadio;
    private JRadioButton authorRadio;
    private JTextField searchBar;
    private JButton searchButton;
    private JButton resetButton;

    private BookTable bookTable;

    private JPanel buttonPanel;
    private JButton myBookInfo;
    private JButton borrowBook;
    private JButton returnBook;
    private JButton reserveBook;
    private JButton addBook;
    private JButton removeBook;
    private JButton logoutButton;

    MainScreenButtonListener listener;

    public MainScreen(MainFrame mf)
    {
        this.setLayout(new BorderLayout());

        listener = new MainScreenButtonListener(this);

        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setPreferredSize(new Dimension(0, 60));
        add(searchPanel, BorderLayout.NORTH);

        titleRadio = new JRadioButton("제목");
        titleRadio.setFont(new Font("맑은고딕", Font.PLAIN, 16));
        titleRadio.setPreferredSize(new Dimension(60, 50));
        titleRadio.setSelected(true);

        authorRadio = new JRadioButton("저자");
        authorRadio.setFont(new Font("맑은고딕", Font.PLAIN, 16));
        authorRadio.setPreferredSize(new Dimension(60, 50));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(titleRadio);
        buttonGroup.add(authorRadio);
        searchPanel.add(titleRadio);
        searchPanel.add(authorRadio);


        searchBar = new JTextField(20);
        searchBar.setPreferredSize(new Dimension(80, 30));
        searchPanel.add(searchBar);

        searchButton = new JButton(MainScreenConst.SEARCH);
        searchButton.setPreferredSize(new Dimension(70, 28));
        searchButton.addActionListener(listener);
        searchPanel.add(searchButton);

        resetButton = new JButton(MainScreenConst.RESET);
        resetButton.setPreferredSize(new Dimension(80, 28));
        resetButton.addActionListener(listener);
        searchPanel.add(resetButton);

        //

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(120, 0));
        buttonPanel.setLayout(null);
        add(buttonPanel, BorderLayout.EAST);
        Font font = new Font("맑은고딕", Font.BOLD, 14);

        myBookInfo = new JButton(MainScreenConst.MY_INFORMATION);
        myBookInfo.setBounds(10, 10, 100, 40);
        myBookInfo.setFont(font);
        buttonPanel.add(myBookInfo);

        borrowBook = new JButton(MainScreenConst.BORROW);
        borrowBook.setBounds(10, 110, 100, 40);
        borrowBook.setFont(font);
        buttonPanel.add(borrowBook);

        returnBook = new JButton(MainScreenConst.RETURN);
        returnBook.setBounds(10, 200, 100, 40);
        returnBook.setFont(font);
        buttonPanel.add(returnBook);

        reserveBook = new JButton(MainScreenConst.RESERVE);
        reserveBook.setBounds(10, 290, 100, 40);
        reserveBook.setFont(font);
        buttonPanel.add(reserveBook);

        addBook = new JButton(MainScreenConst.ADD);
        addBook.setBounds(10, 380, 100, 40);
        addBook.setFont(font);
        buttonPanel.add(addBook);

        removeBook = new JButton(MainScreenConst.REMOVE);
        removeBook.setBounds(10, 470, 100, 40);
        removeBook.setFont(font);
        buttonPanel.add(removeBook);

        logoutButton = new JButton(MainScreenConst.LOGOUT);
        logoutButton.setBounds(10, 650, 100, 40);
        logoutButton.setFont(font);
        logoutButton.addActionListener(e -> new LogoutDialog(mf));
        buttonPanel.add(logoutButton);

        //

        bookTable = new BookTable();
        add(bookTable, BorderLayout.CENTER);
    }

    public BookTable getTable()
    {
        return bookTable;
    }
    public String getText()
    {
        return searchBar.getText();
    }
    public boolean isTitleSelected()
    {
        return titleRadio.isSelected();
    }
}
