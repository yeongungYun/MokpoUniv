import javax.swing.*;
import java.awt.*;

public class MainScreen extends JPanel
{

    private JPanel searchPanel;
    private JRadioButton titleRadio;
    private JRadioButton authorRadio;
    private JRadioButton publisherRadio;
    private JTextField searchBar;
    private JButton searchButton;
    private JButton resetButton;

    private BookTable bookTable;

    private JPanel buttonPanel;
    private JButton myBookInfo;
    private JButton borrowBook;
    private JButton returnBook;
    private JButton reserveBook;
    private JButton reserveCancel;
    private JButton addBook;
    private JButton removeBook;
    private JButton logoutButton;

    private MainScreenListener listener;

    private String id;

    private MainFrame mf;

    public MainScreen(MainFrame mf)
    {
        this.setLayout(new BorderLayout());

        this.mf = mf;
        listener = new MainScreenListener(mf, this);

        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setPreferredSize(new Dimension(0, 60));
        add(searchPanel, BorderLayout.NORTH);

        Font radioFont = new Font("맑은고딕", Font.PLAIN, 14);
        Dimension radioDimension = new Dimension(70, 50);

        titleRadio = new JRadioButton(Const.TITLE);
        titleRadio.setFont(radioFont);
        titleRadio.setPreferredSize(radioDimension);
        titleRadio.setSelected(true);

        authorRadio = new JRadioButton(Const.AUTHOR);
        authorRadio.setFont(radioFont);
        authorRadio.setPreferredSize(radioDimension);

        publisherRadio = new JRadioButton(Const.PUBLISHER);
        publisherRadio.setFont(radioFont);
        publisherRadio.setPreferredSize(radioDimension);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(titleRadio);
        buttonGroup.add(authorRadio);
        buttonGroup.add(publisherRadio);
        searchPanel.add(titleRadio);
        searchPanel.add(authorRadio);
        searchPanel.add(publisherRadio);


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
        myBookInfo.addActionListener(listener);
        buttonPanel.add(myBookInfo);

        borrowBook = new JButton(Const.BORROW);
        borrowBook.setBounds(10, 110, 100, 40);
        borrowBook.setFont(font);
        borrowBook.addActionListener(listener);
        buttonPanel.add(borrowBook);

        returnBook = new JButton(Const.RETURN);
        returnBook.setBounds(10, 180, 100, 40);
        returnBook.setFont(font);
        returnBook.addActionListener(listener);
        buttonPanel.add(returnBook);

        reserveBook = new JButton(Const.RESERVE);
        reserveBook.setBounds(10, 250, 100, 40);
        reserveBook.setFont(font);
        reserveBook.addActionListener(listener);
        buttonPanel.add(reserveBook);

        reserveCancel = new JButton(Const.RESERVE_CANCEL);
        reserveCancel.setBounds(10, 320, 100, 40);
        reserveCancel.setFont(font);
        reserveCancel.addActionListener(listener);
        buttonPanel.add(reserveCancel);

        addBook = new JButton(Const.ADD);
        addBook.setBounds(10, 390, 100, 40);
        addBook.setFont(font);
        addBook.addActionListener(listener);
        buttonPanel.add(addBook);

        removeBook = new JButton(Const.REMOVE);
        removeBook.setBounds(10, 460, 100, 40);
        removeBook.setFont(font);
        removeBook.addActionListener(listener);
        buttonPanel.add(removeBook);

        logoutButton = new JButton(Const.LOGOUT);
        logoutButton.setBounds(10, 650, 100, 40);
        logoutButton.setFont(font);
        logoutButton.addActionListener(listener);
        buttonPanel.add(logoutButton);

        //

        bookTable = new BookTable();
        add(bookTable, BorderLayout.CENTER);
    }

    public void setId(String id) { this.id = id; }
    public String getId() { return id; }
    public BookTable getTable()
    {
        return bookTable;
    }
    public String getText()
    {
        return searchBar.getText();
    }
    public String getSelectedCategory()
    {
        String selectedRadio = "";
        if (titleRadio.isSelected())
        {
            selectedRadio = Const.TITLE;
        }
        else if (authorRadio.isSelected())
        {
            selectedRadio =  Const.AUTHOR;
        }
        else if (publisherRadio.isSelected())
        {
            selectedRadio =  Const.PUBLISHER;
        }
        return selectedRadio;
    }

}
