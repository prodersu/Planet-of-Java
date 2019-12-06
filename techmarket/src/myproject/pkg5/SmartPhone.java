package myproject.pkg5;

public class SmartPhone extends Device{
    private double mgpx;
    private String generation;

    public SmartPhone(double mgpx, String generation, String cpu, int ram, double price, String model, int count, int sold) {
        super(cpu, ram, price, model, count, sold);
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public SmartPhone(String cpu, int ram, double price, String model, int count, int sold) {
        super(cpu, ram, price, model, count, sold);
    }

    public SmartPhone() {
    }

    public double getMgpx() {
        return mgpx;
    }

    public void setMgpx(double mgpx) {
        this.mgpx = mgpx;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public int getPerformance(String cpu, int ram, String model) {
        int b = ram;
        switch(cpu){
            case "corei3": b*=3;break;
            case "corei5": b*=5;break;
            case "corei7": b*=7;break;
            case "corei9": b*=9;break;
        }
        b *= model.length();
        b *= generation.length();
        return b;
    }
    
    @Override
    public String showDetails() {
        return ("SmartPhone: MGPX"+mgpx+
                "Generation: "+generation+
                " CPU: "+getCpu()+
                " RAM: "+getRam()+
                " Model: "+getModel()+
                " Price: "+getPrice()+
                " Count: "+(getCount()-getSold()));
    }
    
}
