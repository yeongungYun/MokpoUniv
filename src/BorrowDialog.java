import javax.swing.*;

public class BorrowDialog extends InputBidDialog
{
    private JButton borrowButton;
    private DialogListener listener;

    public BorrowDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new DialogListener(this);

        borrowButton = new JButton(Const.BORROW);
        borrowButton.setBounds(32, 60, 90, 30);
        borrowButton.addActionListener(listener);
        this.add(borrowButton);

        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
