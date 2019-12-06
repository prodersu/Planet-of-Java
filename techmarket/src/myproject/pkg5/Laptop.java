package myproject.pkg5;

public class Laptop extends Computer{
    private double weight;
    private boolean touch;

    public Laptop(double weight, boolean touch, boolean ssd, int memory, String cpu, int ram, double price, String model, int count, int sold) {
        super(ssd, memory, cpu, ram, price, model, count, sold);
        this.weight = weight;
        this.touch = touch;
    }

    public Laptop(String cpu, int ram, double price, String model, int count, int sold) {
        super(cpu, ram, price, model, count, sold);
    }

    public Laptop() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }
    
   
    
    
    @Override
    public String showDetails() {
        return ("Laptop: "+(isSsd()?"Have ssd, ":"Haven`t ssd, ")+
                "Touch sensor: "+touch+" Memory: "+getMemory()+
                " CPU: "+getCpu()+" RAM: "+getRam()+" Model: "+getModel()+
                " Price "+getPrice()+" Count: "+(getCount()-getSold()));
    }
    
    @Override
    public String toString() {
        return "device= Laptop" + Good.class.toString();
    }
}
