package org.example;
import java.util.HashMap;

public class Library {
    private HashMap<String, LibraryItems> libraryItems;

    public Library() {
        libraryItems = new HashMap<>();
    }

    public void addItem(LibraryItems item) {
        libraryItems.put(item.getId(), item);
    }


    public LibraryItems getItem(String id) {
        return libraryItems.get(id);
    }


    public void removeItem(String id) {
        libraryItems.remove(id);
    }


    public boolean containsItem(String id) {
        return libraryItems.containsKey(id);
    }


    public void displayAllItems() {
        for (LibraryItems item : libraryItems.values()) {
            System.out.println(item.getId() + " - " + item.getTitle()+" - ("+ item.getClass().getSimpleName()+") - "+item.isBorrowedChecker() );
        }
}
}
