
package edu.syr.hw2;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> catalog;

    public void init(String[] publications) {
        this.catalog = new ArrayList<>();
        for (String publication : publications) {
            catalog.add(publication);
        }
    }

    public String search(String query) {
        for (String publication : catalog) {
            if (publication.contains(query)) {
                return publication;
            }
        }
        return "Publication not found";
    }
    // This commented code below is an example of static main method for you to check the code


    public static void main(String[] args) {
        String[] publications = {
            "The Go Programming Language, Alan Donovan and Brian Kernighan",
            "Java Programming for Beginners, John Smith",
            "Python in Practice, Jane Doe"
        };

        Library library = new Library();
        library.init(publications);
        String query = "Go Programming";
        String result = library.search(query);

        if (!result.("Publication not found")) {
            System.out.println("Publication found: " + result);
        } else {
            System.out.println("Publication not found.");
        }
    }
}
