import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

    ///////////////////////////////////// Phone book ////////////////////////////////////////////////

    @Test
    public void testCountEntriesEmpty() {
        PhoneBook t = new PhoneBook();
        assertEquals(0, t.countEntries());
    }

    @Test
    public void testCountEntries() {
        PhoneBook t = new PhoneBook();
        Person p = new Person("Max", "Muster", 666);
        Person p1 = new Person("Max", "S", 666);
        Person p2 = new Person("Max", "K", 555);
        Person p3 = new Person("Max", "J", 333);
        BinNodeGen<Person> root = new BinNodeGen<Person>(p);
        t.root = root;
        t.insertPerson(p1);
        t.insertPerson(p2);
        t.insertPerson(p3);
        assertEquals(4, t.countEntries());
    }

    @Test
    public void testInsertPersonNull() {
        PhoneBook t = new PhoneBook();
        assertEquals(false, t.insertPerson(null));
    }

    @Test
    public void testInsertPersonAlreadyExists() {
        PhoneBook t = new PhoneBook();
        Person p = new Person("Max", "Muster", 666);
        BinNodeGen<Person> root = new BinNodeGen<Person>(p);
        t.root = root;
        assertEquals(false, t.insertPerson(p));

    }

    @Test
    public void testSearchPerson() {
        PhoneBook t = new PhoneBook();
        Person p = new Person("Max", "Muster", 666);
        BinNodeGen<Person> root = new BinNodeGen<Person>(p);
        t.root = root;
        assertEquals(p, t.searchPerson("Muster"));
    }

    @Test(expected = NullPointerException.class)
    public void testSearchPersonNull() {
        PhoneBook t = new PhoneBook();
        Person p = new Person("Max", "Muster", 666);
        BinNodeGen<Person> root = new BinNodeGen<Person>(p);
        t.root = root;
        t.searchPerson("SomeOtherName");
    }



    //////////////////////////////////////Book Catalog//////////////////////////////////////////////

    @Test
    public void testCountBooksEmpty() {
        BookCatalogue a = new BookCatalogue();
        assertEquals(0, a.countBooks());
    }

    @Test
    public void testCountBooks() {
        BookCatalogue a = new BookCatalogue();
        Book b1 = new Book("title1", "author1", 1800);
        Book b2 = new Book("title2", "author2", 1700);
        Book b3 = new Book("title3", "author3", 1900);
        Book b4 = new Book("title4", "author4", 1950);
        Book b5 = new Book("title5", "author5", 1945);
        BinNodeGen<Book> root = new BinNodeGen<Book>(b1);
        a.root = root;
        a.insertBook(b2);
        a.insertBook(b3);
        a.insertBook(b4);
        a.insertBook(b5);
        assertEquals(5, a.countBooks());
    }

    @Test
    public void testCountBooksUntil() {
        BookCatalogue a = new BookCatalogue();
        Book b1 = new Book("title1", "author1", 1800);
        Book b2 = new Book("title2", "author2", 1700);
        Book b3 = new Book("title3", "author3", 1900);
        Book b4 = new Book("title4", "author4", 1950);
        Book b5 = new Book("title5", "author5", 1945);
        BinNodeGen<Book> root = new BinNodeGen<Book>(b1);
        a.root = root;
        a.insertBook(b2);
        a.insertBook(b3);
        a.insertBook(b4);
        a.insertBook(b5);
        assertEquals(2, a.countBooksUntil(1899));
    }

    @Test
    public void testSearchBuch() {
        BookCatalogue a = new BookCatalogue();
        Book b = new Book("Harry Potter", "JK Rowling", 1997);
        BinNodeGen<Book> root = new BinNodeGen<Book>(b);
        a.root = root;
        assertEquals(b, a.searchBook(1997));
    }


    @Test
    public void testGetBooksUntil() {
        BookCatalogue a = new BookCatalogue();
        Book b1 = new Book("title1", "author1", 1800);
        Book b2 = new Book("title2", "author2", 1700);
        Book b3 = new Book("title3", "author3", 1900);
        Book b4 = new Book("title4", "author4", 1950);
        Book b5 = new Book("title5", "author5", 1945);
        BinNodeGen<Book> root = new BinNodeGen<Book>(b1);
        a.root = root;
        a.insertBook(b2);
        a.insertBook(b3);
        a.insertBook(b4);
        a.insertBook(b5);
        System.out.println(a.getAllUntil(1900));
    }






}