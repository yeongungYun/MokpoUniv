import javax.swing.*;

public class BorrowDialog extends InputBidDialog
{
    private JButton borrowButton;

    public BorrowDialog(MainFrame mainFrame, String title)
    {
        super(mainFrame, title);
        borrowButton = new JButton(Const.BORROW);
        borrowButton.setBounds(32, 60, 90, 30);
        borrowButton.addActionListener(listener);
        this.add(borrowButton);


        setResizable(false);
        setVisible(true);
    }
}
