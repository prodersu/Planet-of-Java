package myproject.pkg5;

public class Computer extends Device{
    private boolean ssd;
    private int memory;

    public Computer(boolean ssd, int memory, String cpu, int ram, double price, String model, int count, int sold) {
        super(cpu, ram, price, model, count, sold);
        this.ssd = ssd;
        this.memory = memory;
    }

    public Computer(String cpu, int ram, double price, String model, int count, int sold) {
        super(cpu, ram, price, model, count, sold);
    }

    public Computer() {
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
    
    
   
    
    @Override
    public String showDetails() {
        return ("Computer: "+(ssd?"Have ssd, ":"Haven`t ssd, ")+"GB memory, "+memory +" CPU: "+getCpu()
                +"RAM: " +getRam()+" Model: "+getModel()
                +"Price: "+getPrice()+" Count: "+(getCount()-getSold()));
    }
    
    @Override
    public String toString() {
        return "device= Computer" + Good.class.toString();
    }

    @Override
    public int getPerformance(String cpu, int ram, String model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
