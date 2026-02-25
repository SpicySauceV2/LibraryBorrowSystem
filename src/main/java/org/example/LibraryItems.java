package org.example;

public abstract class LibraryItems implements libraryRules {
    protected String id;
    protected String title;
    protected Boolean isBorrowed;
    protected int maxBorrowedDays;

    public LibraryItems (String id,String title,Boolean isBorrowed,int maxBorrowedDays){
        this.id = id;
        this.title = title;
        this.isBorrowed = isBorrowed;
        this.maxBorrowedDays = maxBorrowedDays;
    }
    public void borrow() {
        if (this.isBorrowed == Boolean.TRUE){
            System.out.println("Book already is borrowed");
        }else{
            this.isBorrowed = Boolean.TRUE;
        }
    }

    public void returnItem() {
        if (this.isBorrowed == Boolean.FALSE){
            System.out.println("Book already returned");
        }else{
            this.isBorrowed = Boolean.FALSE;
        }
    }
    public void getDaysTillReturn(){
        System.out.println(this.getMaxBorrowedDays() + " Days till " +this.getClass()+ " needs to be returned.");
    }
    public void getItemType(){
        System.out.println("This is a " +this.getClass());
    }


    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
    public String isBorrowedChecker() {
        if (isBorrowed == Boolean.FALSE){
            return "AVAILABLE";
        }else {
            return "BORROWED";
        }

    }

    public int getMaxBorrowedDays() {
        return maxBorrowedDays;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }
}
