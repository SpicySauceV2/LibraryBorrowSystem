package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book("B001", "Java Programming", false, 14, "John Smith");

        library.addItem(book1);

        library.displayAllItems();
    }
}
