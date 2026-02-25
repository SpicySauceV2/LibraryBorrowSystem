package org.example;

public class Book extends LibraryItems {

    private String author;

    public Book(String id, String title, boolean isBorrowed, int maxBorrowedDays, String author) {
        super(id, title, isBorrowed, maxBorrowedDays);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
