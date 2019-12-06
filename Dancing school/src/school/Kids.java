package school;

public class Kids extends Courses {
    private int age;
    private boolean tour;

    public Kids(String title, String master, String schedule, int price, int sold,int count, int age, boolean tour) {
        super(title, master, schedule, price, sold, count);
        this.age = age;
        this.tour = tour;
    }

    public Kids(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTour() {
        return tour;
    }

    public void setTour(boolean tour) {
        this.tour = tour;
    }
     @Override
    public String showDetails() {
        return ("Adult course:" + getTitle() + getMaster() + getSchedule() + 
                getPrice() + getSold() + getAge() + isTour() + getCount());
    }
    
    @Override
    public String toString() {
        return "Course = Kids" + Courses.class.toString();
    }
}
