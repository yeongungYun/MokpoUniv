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

    private BookListPanel bookTable;

    private JPanel buttonPanel;
    private JButton myBookInfo;
    private JButton borrowBook;
    private JButton returnBook;
    private JButton reserveBook;
    private JButton addBook;
    private JButton removeBook;
    private JButton logoutButton;

    MainScreenListener listener;

    String id = null;

    public MainScreen(MainFrame mf)
    {
        this.setLayout(new BorderLayout());

        listener = new MainScreenListener(mf, this);

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

        searchButton = new JButton(Const.SEARCH);
        searchButton.setPreferredSize(new Dimension(70, 28));
        searchButton.addActionListener(listener);
        searchPanel.add(searchButton);

        resetButton = new JButton(Const.RESET);
        resetButton.setPreferredSize(new Dimension(80, 28));
        resetButton.addActionListener(listener);
        searchPanel.add(resetButton);

        //

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(120, 0));
        buttonPanel.setLayout(null);
        add(buttonPanel, BorderLayout.EAST);
        Font font = new Font("맑은고딕", Font.BOLD, 14);

        myBookInfo = new JButton(Const.MY_INFORMATION);
        myBookInfo.setBounds(10, 10, 100, 40);
        myBookInfo.setFont(font);
        buttonPanel.add(myBookInfo);

        borrowBook = new JButton(Const.BORROW);
        borrowBook.setBounds(10, 110, 100, 40);
        borrowBook.setFont(font);
        borrowBook.addActionListener(listener);
        buttonPanel.add(borrowBook);

        returnBook = new JButton(Const.RETURN);
        returnBook.setBounds(10, 200, 100, 40);
        returnBook.setFont(font);
        returnBook.addActionListener(listener);
        buttonPanel.add(returnBook);

        reserveBook = new JButton(Const.RESERVE);
        reserveBook.setBounds(10, 290, 100, 40);
        reserveBook.setFont(font);
        reserveBook.addActionListener(listener);
        buttonPanel.add(reserveBook);

        addBook = new JButton(Const.ADD);
        addBook.setBounds(10, 380, 100, 40);
        addBook.setFont(font);
        buttonPanel.add(addBook);

        removeBook = new JButton(Const.REMOVE);
        removeBook.setBounds(10, 470, 100, 40);
        removeBook.setFont(font);
        buttonPanel.add(removeBook);

        logoutButton = new JButton(Const.LOGOUT);
        logoutButton.setBounds(10, 650, 100, 40);
        logoutButton.setFont(font);
        logoutButton.addActionListener(listener);
        buttonPanel.add(logoutButton);

        //

        bookTable = new BookListPanel();
        add(bookTable, BorderLayout.CENTER);
    }

    public void setId(String id) { this.id = id; }
    public String getId() { return id; }
    public BookListPanel getTablePanel()
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
