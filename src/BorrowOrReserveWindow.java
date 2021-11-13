public class BorrowOrReserveWindow extends Window
{
    public BorrowOrReserveWindow(MainFrame mf)
    {
        super("도서 대출/예약");
        setSize(500, 650);
        setLocationRelativeTo(mf.getComponent());
    }
}
