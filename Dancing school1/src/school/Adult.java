package school;

/**
 * Created by 28354 on 27.11.2019.
 */
public class Adult extends Courses {
    private String style;
    private String gender;
    private String indiv_group;

    public Adult(String title, String master, String schedule, int price, int sold, int count, String style, String gender, String indiv_group) {
        super(title, master, schedule, price, sold, count);
        this.style = style;
        this.gender = gender;
        this.indiv_group = indiv_group;
    }

    public Adult(){}

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIndiv_group() {
        return indiv_group;
    }

    public void setIndiv_group(String indiv_group) {
        this.indiv_group = indiv_group;
    }
     @Override
    public String showDetails() {
        return ("Adult course:" + getTitle() + " in "+ getStyle()+" "+ getMaster() + " on " + getSchedule()
                + " for " + getGender() + " to " + getIndiv_group());
    }
    
    @Override
    public String toString() {
        return "Course = adult" + Courses.class.toString();
    }
}
