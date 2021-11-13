public class MyInfoWindow extends Window
{
    public MyInfoWindow(MainFrame mf)
    {
        super("내 도서 정보");
        setSize(400, 550);
        setLocationRelativeTo(mf.getComponent());
    }
}
