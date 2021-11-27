import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener
{
    AddDialog dialog;
    public AddListener(AddDialog dialog)
    {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals(Const.ADD))
        {
            String isbn = dialog.getIsbn();
            String title = dialog.getTitle();
            String author = dialog.getAuthor();
            String publisher = dialog.getPublisher();
            String publishDate = dialog.getPublishDate();

            if (isbn.equals("") || title.equals("") || author.equals("")
                    || publisher.equals("") || publishDate.equals("")) // 기입하지 않은 항목이 있음
            {
                JOptionPane.showMessageDialog(null,
                        Const.FILL_IN_FORM, Const.ADD, JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                BooksDatabase.getInstance().add(isbn, title, author, publisher, publishDate);
                dialog.getTable().resetTable();
                JOptionPane.showMessageDialog(null,
                        Const.ADD_COMPLETE, Const.ADD, JOptionPane.PLAIN_MESSAGE);
            }
        }
        else if (e.getActionCommand().equals(Const.CLOSE))
        {
            dialog.dispose();
        }
    }
}
