package pl.edu.agh.dronka.shop.model;

public class Book extends Item {

    private int pages;
    private boolean hardcover;

    public Book(String name, Category category, int price, int quantity, int pages, boolean hardcover){
        super(name, category, price, quantity);
        this.pages = pages;
        this.hardcover = hardcover;
    }
    public Book(){}

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean getHardcover() {
        return hardcover;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }
}
