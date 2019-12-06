package myproject.pkg5;

public abstract class Wearing extends Good{
    String size;
    String color;

    public Wearing() {
    }

    public Wearing(String size, String color, double price, String model, int count, int sold) {
        super(price, model, count, sold);
        this.size = size;
        this.color = color;
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public abstract String getCategories();
}