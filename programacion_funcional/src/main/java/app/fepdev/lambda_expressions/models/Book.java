package app.fepdev.lambda_expressions.models;

public class Book {

    public String name;
    public int pages;
    public int current;

    public Book(String name, int pages, int current) {
        this.name = name;
        this.pages = pages;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", pages=" + pages + ", current=" + current + "]";
    }

    

    
}
