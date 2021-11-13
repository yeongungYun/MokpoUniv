public class Main
{
    public static void main(String[] args)
    {
        MembersDBManager membersDB =  new MembersDBManager("members");
        BooksDBManager booksDB = new BooksDBManager("books");
        new MainFrame(membersDB, booksDB);
    }
}
