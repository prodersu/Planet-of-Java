package myproject.pkg5;

public class Tshirt extends Wearing{
    String material;

    public Tshirt() {
    }

    public Tshirt(String material, String size, String color, double price, String model, int count, int sold) {
        super(size, color, price, model, count, sold);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getCategories() {
        String s = "";
        if((getSize()=="s"||getSize()=="xs"))s+="kid ";
        else if (getSize()=="m"||getSize()=="l")s+="teen ";
        else s+="adult ";
        if (s=="kid "||s=="teen"){
            if(getColor()=="ping")s+="girl ";
            else if(getColor()=="black")s+="boy ";
        }
        s+="tshirt";
        return s;
    }

    @Override
    public String showDetails() {
        return ("T-Shirt: Color: "+getColor()+" Material: "+material+"for "+
                getCategories()+"size: "+getSize()
                +" Model: "+getModel()+"Price:"
                +getPrice()+" Count: "+(getCount()-getSold()));
    }
    
}
