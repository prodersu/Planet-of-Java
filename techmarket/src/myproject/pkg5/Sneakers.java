package myproject.pkg5;

public class Sneakers extends Wearing{
    String season;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String getCategories() {
        String s="";
        int d = Integer.parseInt(getSize());
        if(d<30){
            s +="kid ";
        }
        else if(d<40){
            s+="teen ";
        }
        else if(d<50){
            s+="adult ";
        }
        s+="sneakers";
        return s;
    }

    @Override
    public String showDetails() {
        return ("Sneakers: Color:"+getColor()+" Category: "+getCategories()+"season: "+season+"size: "+getSize()+" model: "+getModel()+"price: "+getPrice()+" count: "+(getCount()-getSold()));
    }

    public Sneakers(String season, String size, String color, double price, String model, int count, int sold) {
        super(size, color, price, model, count, sold);
        this.season = season;
    }

    public Sneakers() {
    }
    
}
