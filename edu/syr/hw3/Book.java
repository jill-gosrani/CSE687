// Name : Pavan Pandya
// NetID : pjpandya@syr.edu
// Su ID : 340197894
package edu.syr.hw3;

public class Book {

    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;
    private BookType type;

    public Book(String a, String t, String p, String i, int y, BookType b) {
        this.author = a;
        this.title = t;
        this.publisher = p;
        this.isbn = i;
        this.yearPublished = y;
        this.type = b;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public BookType getType() {
        return type;
    }
    // Adding a toString Method in the given Book Class 
    @Override
    public String toString() {
            return "Book {" + 
                   "\n author = " + author + 
                   "\n isbn = " + isbn + 
                   "\n publisher = " + publisher + 
                   "\n title = " + title + 
                   "\n yearPublished=" + yearPublished + 
                   "\n  type="+ type + 
                   "} \n";
    }
    // Adding an equals method in the given Book class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Book book_obj = (Book) obj;
        // we can use any 1 of the 2 methods given below 1st method is commented by me you can use this method.
        //METHOD 1
        // if (!this.author.equals(book_obj.author))
        //     return false;
        // if (!this.isbn.equals(book_obj.isbn))
        //     return false;
        // if (!this.publisher.equals(book_obj.publisher))
        //     return false;
        // if (!this.title.equals(book_obj.title))
        //     return false;
        // if (this.yearPublished != book_obj.yearPublished)
        //     return false;
        // return true;

        // METHOD 2
        return this.author.equals(book_obj.author) && this.author.equals(book_obj.title) && this.publisher.equals(book_obj.publisher) && this.isbn.equals(book_obj.isbn) && this.yearPublished == book_obj.yearPublished && this.type == book_obj.type;
    }



    // Adding a Hashcode in the given Book Class
    @Override
    public int hashCode() {
        final int prime = 31; 
        int result = 13; // 13 is taken arbitarily 
        //We can take any prime number in result instead of 31
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + yearPublished;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /*
     * 
     * For testing purpose
     * Param: String array
     * Return: Void
     */
     
    public static void main(String[] args) {
        Book b1 = new Book(null, "Learning Spark", "O'Reilly", "9781449358624", 2015,BookType.HARDCOVER);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011,BookType.EBOOK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016,BookType.ANY);
        Book b4 = new Book("", "lear", "", "9781449358624",0,BookType.EBOOK);
        Book b5 = new Book("Holden Karau 1", "Learning Spark", "O'Reilly", "9781449358624", 2015,BookType.HARDCOVER);
        Book b6 = new Book("", "", "", " ",0,BookType.PAPERBACK);
        System.out.println(b1.toString());
        System.out.println(b2.hashCode());
        //System.out.println(b3.hashCode());
        Library l = new Library();

        l.add(b1);
        // l.add(b2);
        // l.add(b3);
        // l.add(b1);
        // l.add(b5);
        //l.add(b2);
        
    }
}