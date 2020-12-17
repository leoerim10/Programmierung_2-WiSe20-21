public class Book implements Comparable<Book>{
    String title, author;
    int yearPublished;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(){
    }

    public int getYearPublished() {
        return yearPublished;
    }


    @Override
    public int compareTo(Book o) {
        if(this.yearPublished < o.yearPublished) {
            return -1;
        }
        else if(this.yearPublished > o.yearPublished) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("%s by %s, %d", title, author, yearPublished);
    }

}