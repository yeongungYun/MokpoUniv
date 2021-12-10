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
    private JButton myBookInfoButton;
    private JButton borrowButton;
    private JButton returnButton;
    private JButton reserveButton;
    private JButton reserveCancelButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton logoutButton;

    private MainScreenListener listener;

    private String id;

    public MainScreen(MainFrame mainFrame)
    {
        this.setLayout(new BorderLayout());

        listener = new MainScreenListener(mainFrame, this);

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

        myBookInfoButton = new JButton(Const.MY_INFORMATION);
        myBookInfoButton.setBounds(10, 10, 100, 40);
        myBookInfoButton.setFont(font);
        myBookInfoButton.addActionListener(listener);
        buttonPanel.add(myBookInfoButton);

        borrowButton = new JButton(Const.BORROW);
        borrowButton.setBounds(10, 110, 100, 40);
        borrowButton.setFont(font);
        borrowButton.addActionListener(listener);
        buttonPanel.add(borrowButton);

        returnButton = new JButton(Const.RETURN);
        returnButton.setBounds(10, 180, 100, 40);
        returnButton.setFont(font);
        returnButton.addActionListener(listener);
        buttonPanel.add(returnButton);

        reserveButton = new JButton(Const.RESERVE);
        reserveButton.setBounds(10, 250, 100, 40);
        reserveButton.setFont(font);
        reserveButton.addActionListener(listener);
        buttonPanel.add(reserveButton);

        reserveCancelButton = new JButton(Const.RESERVE_CANCEL);
        reserveCancelButton.setBounds(10, 320, 100, 40);
        reserveCancelButton.setFont(font);
        reserveCancelButton.addActionListener(listener);
        buttonPanel.add(reserveCancelButton);

        addButton = new JButton(Const.ADD);
        addButton.setBounds(10, 390, 100, 40);
        addButton.setFont(font);
        addButton.addActionListener(listener);
        buttonPanel.add(addButton);

        removeButton = new JButton(Const.REMOVE);
        removeButton.setBounds(10, 460, 100, 40);
        removeButton.setFont(font);
        removeButton.addActionListener(listener);
        buttonPanel.add(removeButton);

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
    public String getSearchBarText()
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
