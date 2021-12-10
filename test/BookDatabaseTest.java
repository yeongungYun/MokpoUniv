import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookDatabaseTest
{
    // 테스트를 위해 bid 1번 책은
    // 대출 및 예약된 상태

    @Test
    void checkExistsTable()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        boolean ret = bookDatabase.checkExistsTableTest();
        assertTrue(ret);
    }

    @Test
    void borrowCheckMessage()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        String str1 = bookDatabase.borrowCheckMessage(99);
        assertEquals(str1, Const.NON_EXISTENET_BID);
        String str2 = bookDatabase.borrowCheckMessage(1);
        assertEquals(str2, Const.ALREADY_BORROWED);
        String str3 = bookDatabase.borrowCheckMessage(2);
        assertEquals(str3, Const.CAN);
    }

    @Test
    void returnCheckMessage()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        String str1 = bookDatabase.returnCheckMessage(99, "yun");
        assertEquals(str1, Const.NON_EXISTENET_BID);
        String str2 = bookDatabase.returnCheckMessage(1, "test");
        assertEquals(str2, Const.NOT_BORROWED_BY_ME);
        String str3 = bookDatabase.returnCheckMessage(1, "yun");
        assertEquals(str3, Const.CAN);
    }

    @Test
    void reserveCheckMessage()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        String str1 = bookDatabase.reserveCheckMessage(99);
        assertEquals(str1, Const.NON_EXISTENET_BID);
        String str2 = bookDatabase.reserveCheckMessage(1);
        assertEquals(str2, Const.ALREADY_RESERVED);
        String str3 = bookDatabase.reserveCheckMessage(2);
        assertEquals(str3, Const.CAN);
    }

    @Test
    void reserveCancelCheckMessage()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        String str1 = bookDatabase.reserveCancelCheckMessage(99, "yun");
        assertEquals(str1, Const.NON_EXISTENET_BID);
        String str2 = bookDatabase.reserveCancelCheckMessage(1, "test");
        assertEquals(str2, Const.NOT_RESERVED_BY_ME);
        String str3 = bookDatabase.reserveCancelCheckMessage(1, "yun");
        assertEquals(str3, Const.CAN);
        String str4 = bookDatabase.reserveCancelCheckMessage(2, "yun");
        assertEquals(str4, Const.NOT_RESERVED_BY_ME);
    }

    @Test
    void removeCheckMessage()
    {
        BookDatabase bookDatabase = BookDatabase.getInstance();
        String str1 = bookDatabase.removeCheckMessage(99);
        assertEquals(str1, Const.NON_EXISTENET_BID);
        String str2 = bookDatabase.removeCheckMessage(1);
        assertEquals(str2, Const.CANT_REMOVE);
        String str3 = bookDatabase.removeCheckMessage(2);
        assertEquals(str3, Const.CAN);
    }

    @Test
    // void -> boolean
    void borrowAndReturn()
    {
        int bid = 2;
        String id = "yun";
        BookDatabase bookDatabase = BookDatabase.getInstance();
        boolean borrowRet = bookDatabase.borrow(bid, id);
        assertTrue(borrowRet);
        boolean returnRet = bookDatabase.returnBook(bid);
        assertTrue(returnRet);
    }

    @Test
    // void -> boolean
    void reserveAndReserveCancel()
    {
        int bid = 2;
        String id = "yun";
        BookDatabase bookDatabase = BookDatabase.getInstance();
        boolean reserveRet = bookDatabase.reserve(bid, id);
        assertTrue(reserveRet);
        boolean reserveCancelRet = bookDatabase.reserveCancel(bid);
        assertTrue(reserveCancelRet);
    }
}
