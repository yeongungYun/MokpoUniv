import javax.swing.*;

public class RemoveDialog extends InputBidDialog
{
    private JButton removeButton;
    private DialogListener listener;
    public RemoveDialog(MainFrame mf, String title)
    {
        super(mf, title);

        listener = new DialogListener(this);

        removeButton = new JButton(Const.REMOVE);
        removeButton.setBounds(32, 60, 70, 30);
        removeButton.addActionListener(listener);
        this.add(removeButton);

        closeButton.addActionListener(listener);

        setResizable(false);
        setVisible(true);
    }
}
