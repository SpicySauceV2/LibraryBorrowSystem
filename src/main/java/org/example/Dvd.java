package org.example;

public class Dvd extends LibraryItems {

    private String director;
    private int durationMinutes;
    private String genre;

    public Dvd(String id, String title, boolean isBorrowed, int maxBorrowedDays,
               String director, int durationMinutes, String genre) {

        super(id, title, isBorrowed, maxBorrowedDays);
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "DVD [ID=" + id +
                ", Title=" + title +
                ", Director=" + director +
                ", Duration=" + durationMinutes + " mins" +
                ", Genre=" + genre +
                ", Borrowed=" + isBorrowed +
                ", Max Days=" + maxBorrowedDays +
                "]";
    }
}
