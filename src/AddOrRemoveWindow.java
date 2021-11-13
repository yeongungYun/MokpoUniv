public class AddOrRemoveWindow extends Window
{
    public AddOrRemoveWindow(MainFrame mf)
    {
        super("도서 추가/삭제");
        setSize(500, 650);
        setLocationRelativeTo(mf.getComponent());
    }
}
