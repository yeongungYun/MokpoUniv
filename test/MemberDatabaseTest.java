import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberDatabaseTest
{

    @Test
    void checkExistsTable()
    {
        MemberDatabase memberDatabase = MemberDatabase.getInstance();
        boolean ret = memberDatabase.checkExistsTableTest();
        assertTrue(ret);
    }

    @Test
    void login()
    {
        MemberDatabase memberDatabase = MemberDatabase.getInstance();
        String str1 = memberDatabase.login("yun", "test1234");
        assertEquals(str1, Const.LOGIN_COMPLETE);
        String str2 = memberDatabase.login("yun", "wrongpassword");
        assertEquals(str2, Const.LOGIN_FAILED);
        String str3 = memberDatabase.login("dontExistId", "test1234");
        assertEquals(str3, Const.LOGIN_FAILED);
    }

    @Test
    void signUp()
    {
        MemberDatabase memberDatabase = MemberDatabase.getInstance();
        String str1= memberDatabase.signUp("testId", "test1234");
        assertEquals(str1, Const.SIGNUP_COMPLETE);
        String str2 = memberDatabase.signUp("yun", "1234");
        assertEquals(str2, Const.EXIST_SAME_ID);
    }
}