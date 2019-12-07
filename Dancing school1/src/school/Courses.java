package school;

public abstract class Courses {
    private String title;
    private String master;
    private String schedule;    
    private int price;
    private int sold;
    private int count;

    public Courses(String title, String master, String schedule, int price, int sold, int count) {
        this.title = title;
        this.master = master;
        this.schedule = schedule;
        this.price = price;
        this.sold = sold;
        this.count = count;
    }
    
    public Courses(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
     public abstract String showDetails();

    @Override
    public String toString() {
        return showDetails();
    }
    
}
