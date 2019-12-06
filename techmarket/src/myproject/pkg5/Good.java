package myproject.pkg5;

public abstract class Good {
    private double price;
    private String model;
    private int count;
    private int sold;

    public Good(double price, String model, int count, int sold) {
        this.price = price;
        this.model = model;
        this.count = count;
        this.sold = sold;
    }

    public Good() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
    public abstract String showDetails();

    @Override
    public String toString() {
        return showDetails();
    }
}