import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogListener implements ActionListener
{
    MainFrame mf;
    Dialog dialog;

    public DialogListener(Dialog dialog)
    {
        this.dialog = dialog;
        this.mf = dialog.getMainFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String id;
        String password;
        String message;
        String againPassword;

        int bid;

        switch (e.getActionCommand())
        {
            case Const.LOGIN :
                LoginDialog loginDialog = (LoginDialog) dialog;
                id = loginDialog.getId();
                password = loginDialog.getPassword();
                message = MemberDatabase.getInstance().login(id, password);
                if (message.equals(Const.LOGIN_COMPLETE))
                {
                    mf.changeToMainScreen(id);
                    dialog.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            message,
                            "로그인", JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case Const.SIGNUP :
                SignUpDialog signupDialog = (SignUpDialog) dialog;
                id = signupDialog.getId();
                password = signupDialog.getPassword();
                againPassword = signupDialog.getAgainPassword();

                if (id.length() <= 0 || id.length() > 10)
                {
                    message = Const.WRONG_ID;
                }
                else if (password.length() <= 0 || password.length() > 15)
                {
                    message = Const.WRONG_PASSWORD;
                }
                else if (!password.equals(againPassword))
                {
                    message = Const.DIFFERENT_PASSWORD;
                }
                else
                {
                    message = MemberDatabase.getInstance().signUp(id, password, againPassword);
                }

                JOptionPane.showMessageDialog(null,
                        message,
                        Const.SIGNUP, JOptionPane.PLAIN_MESSAGE);

                if (message.equals(Const.WRONG_ID) ||
                        message.equals(Const.EXIST_SAME_ID))
                {
                    signupDialog.initIdField();
                    signupDialog.initPasswordField();
                    signupDialog.initAgainPasswordField();
                }
                else if (message.equals(Const.WRONG_PASSWORD))
                {
                    signupDialog.initPasswordField();
                    signupDialog.initAgainPasswordField();
                }
                else if (message.equals(Const.DIFFERENT_PASSWORD))
                {
                    signupDialog.initAgainPasswordField();
                }
                break;

            case Const.BORROW :
                BorrowDialog borrowDialog = (BorrowDialog) dialog;
                id = borrowDialog.getId();
                bid = borrowDialog.getBid();
                message = BookDatabase.getInstance().borrowCheckMessage(bid);
                if (message.equals(Const.CAN))
                {
                    BookDatabase.getInstance().borrow(bid, id);
                    borrowDialog.getTable().resetTable();
                    JOptionPane.showMessageDialog(null,
                            Const.BORROW_COMPLETE, Const.BORROW, JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            message, Const.BORROW, JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case Const.RETURN :
                ReturnDialog returnDialog = (ReturnDialog) dialog;
                bid = returnDialog.getBid();
                if (bid > -1)
                {
                    id = returnDialog.getId();
                    message = BookDatabase.getInstance().returnCheckMessage(bid, id);
                    if (message.equals(Const.CAN))
                    {
                        BookDatabase.getInstance().returnBook(bid);
                        returnDialog.getTable().resetTable();
                        JOptionPane.showMessageDialog(null,
                                Const.RETURN_COMPLETE, Const.RETURN, JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                message, Const.RETURN, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                break;

            case Const.RESERVE :
                ReserveDialog reserveDialog = (ReserveDialog) dialog;
                bid = reserveDialog.getBid();
                if (bid > -1)
                {
                    message = BookDatabase.getInstance().reserveCheckMessage(bid);
                    if (message.equals(Const.CAN))
                    {
                        id = reserveDialog.getId();
                        BookDatabase.getInstance().reserve(bid, id);
                        reserveDialog.getTable().resetTable();
                        JOptionPane.showMessageDialog(null,
                                Const.RESERVE_COMPLETE, Const.RESERVE, JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                message, Const.RESERVE, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                break;

            case Const.RESERVE_CANCEL :
                ReserveCancelDialog reserveCancelDialog = (ReserveCancelDialog) dialog;
                bid = reserveCancelDialog.getBid();
                if (bid > -1)
                {
                    id = reserveCancelDialog.getId();
                    message = BookDatabase.getInstance().reserveCancelCheckMessage(bid, id);
                    if (message.equals(Const.CAN))
                    {
                        BookDatabase.getInstance().reserveCancel(bid);
                        reserveCancelDialog.getTable().resetTable();
                        JOptionPane.showMessageDialog(null,
                                Const.RESERVE_CANCEL_COMPLETE, Const.RESERVE_CANCEL, JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                message, Const.RESERVE_CANCEL, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                break;

            case Const.ADD :
                AddDialog addDialog = (AddDialog) dialog;
                if (!addDialog.fillOutAllForm()) // 기입하지 않은 항목이 있음
                {
                    JOptionPane.showMessageDialog(null,
                            Const.FILL_OUT_FORM, Const.ADD, JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    String isbn = addDialog.getIsbn();
                    String title = addDialog.getTitle();
                    String author = addDialog.getAuthor();
                    String publisher = addDialog.getPublisher();
                    String publishDate = addDialog.getPublishDate();
                    String registerDate = addDialog.getRegisterDate();
                    BookDatabase.getInstance().add(isbn, title, author, publisher, publishDate, registerDate);
                    addDialog.getTable().resetTable();
                    JOptionPane.showMessageDialog(null,
                            Const.ADD_COMPLETE, Const.ADD, JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case Const.REMOVE :
                RemoveDialog removeDialog = (RemoveDialog) dialog;
                bid = removeDialog.getBid();
                if (bid > -1)
                {
                    message = BookDatabase.getInstance().removeCheckMessage(bid);
                    if (message.equals(Const.CAN))
                    {
                        BookDatabase.getInstance().remove(bid);
                        removeDialog.getTable().resetTable();
                        JOptionPane.showMessageDialog(null,
                                Const.REMOVE_COMPLETE, Const.REMOVE, JOptionPane.PLAIN_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                message, Const.REMOVE, JOptionPane.PLAIN_MESSAGE);
                    }
                }
                break;

            case Const.LOGOUT :
                dialog.dispose();
                mf.changeToInitialScreen();
                break;

            case Const.CLOSE :
                dialog.dispose();
                break;

            case Const.SHOW_PASSWORD :
                SignUpDialog signUpDialog = (SignUpDialog) dialog;
                if (signUpDialog.getCheckbox())
                {
                    signUpDialog.showPassword();
                }
                else
                {
                    signUpDialog.hidePassword();
                }
        }
    }
}
