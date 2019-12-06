package myproject.pkg5;

public abstract class Device extends Good{
    private String cpu;
    private int ram;

    public Device(String cpu, int ram, double price, String model, int count, int sold) {
        super(price, model, count, sold);
        this.cpu = cpu;
        this.ram = ram;
    }

    public Device() {
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
    
    public abstract int getPerformance(String cpu, int ram, String model);
}
