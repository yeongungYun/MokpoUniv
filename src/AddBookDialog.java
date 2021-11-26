import javax.swing.*;

public class AddBookDialog extends JDialog
{
    
    public AddBookDialog(MainFrame mf, String title)
    {
        super(mf, title);
        setSize(280, 150);
        setLocationRelativeTo(mf.getComponent());
        setLayout(null);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        setResizable(false);
        setVisible(true);
    }
}
