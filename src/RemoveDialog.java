import javax.swing.*;

public class RemoveDialog extends InputBidDialog
{
    private JButton removeButton;
    public RemoveDialog(MainFrame mainFrame, String title)
    {
        super(mainFrame, title);

        removeButton = new JButton(Const.REMOVE);
        removeButton.setBounds(32, 60, 70, 30);
        removeButton.addActionListener(listener);
        this.add(removeButton);
        setResizable(false);
        setVisible(true);
    }
}
