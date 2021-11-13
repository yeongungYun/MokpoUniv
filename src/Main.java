public class Main
{
    public static void main(String[] args)
    {
        MembersDBManager membersDB =  new MembersDBManager("members", "member");
        BooksDBManager booksDB = new BooksDBManager("books", "book");
        new MainFrame(membersDB, booksDB);
    }
}
