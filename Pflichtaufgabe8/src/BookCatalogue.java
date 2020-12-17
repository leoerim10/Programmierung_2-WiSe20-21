public class BookCatalogue extends BinTreeGen<Book>{

    public BookCatalogue(BinNodeGen<Book> root) {
        super(root);
    }

    public BookCatalogue(Book b) {
        super(b);
    }

    public BookCatalogue(){
    }

    /**
     * insert the new book to the catalogue
     * @param p new book to be added
     * @return true if the book was successfully added
     */
    public boolean insertBook(Book p) {
        boolean result = super.insertNode(p);
        return result;
    }

    /**
     * count the number of book in catalogue
     * @return the number of books
     */
    public int countBooks() {
        return super.countNodes();
    }

    /**
     * count all the books in the catalogue, which were published in the year or earlier
     * @param year with which the book is represented
     * @return the number of books
     */
    public int countBooksUntil(int year) {
        return countBooksUntil(super.root, year);
    }

    /**
     * count all the books in the catalogue, which were published in the year or earlier
     * @param n given node
     * @param year  with which the book is represented
     * @return the total number of the books
     */
    private int countBooksUntil(BinNodeGen<Book> n, int year) {
        if(n == null)
            return 0;

        if(n.data.yearPublished <= year) {
            int count = 1 + (n.left == null ? 0 : super.countNodes(n.left));
            if (n.data.yearPublished == year)
                return count;
            return count + countBooksUntil(n.right, year);
        }
        else return countBooksUntil(n.left, year);
    }


    /**
     * search book in the catalogue with the given year
     * @param year with which the book is represented
     * @return the book with details
     */
    public Book searchBook(int year) {
        Book b = new Book("", "", year);
        BinNodeGen<Book> toReturn = super.find(b);
        return toReturn.data;
    }


    /**
     * returns the books with the given year as string
     * @param year with which the book is represented
     * @return the book as string
     */
    public String getAllUntil(int year) {
        return getBooksUntil(super.root, year);
    }

    /**
     * returns the books with the given year as string
     * @param n given node
     * @param year with which the book is represented
     * @return the book as string
     */
    private String getBooksUntil(BinNodeGen<Book> n, int year) {
        if(n == null)
            return "";
        if(n.data.yearPublished <= year) {
            String s = n.data.toString() + "\n" + (n.left == null ? "" : super.toString(n.left));
            if(n.data.yearPublished == year)
                return s;
            return s + getBooksUntil(n.right, year);
        }
        else return getBooksUntil(n.left, year);
    }


    ////////////////////////////////////////////////////////////

    public void print() {
        super.print2D();
    }


}