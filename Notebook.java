public class Notebook {
    public int RAM;
    public int HDD;
    public double CPU_perfomance;
    public double price;
    public String brandname;
    public String OS;
    public String Color;
    public String name;
    public boolean available;

    public Notebook(String name, String brandname, int RAM, int HDD, double perf, String OS, String color, boolean available,double price)
    {
        this.name = name;
        this.brandname = brandname;
        this.RAM = RAM;
        this.HDD = HDD;
        this.CPU_perfomance = perf;
        this.OS = OS;
        this.Color = color;
        this.available = available;
        this.price = price;
    }

    public String info()
    {
        return String.format("Notebook '%s' (manufacturer: %s, RAM: %s, HDD: %s, Prefomance: %s, OS: %s, color:%s) %s! ONLY %s!!!",
        name, brandname, RAM, HDD, CPU_perfomance, OS, Color, (available)?"IS AVAILABLE NOW":"IS NOT AVAILABLE",(available)?price+"$":"PRE ORDER");
    }

    public void Select(Cart cart)
    {
        cart.add(this);
        cart.print();
    }
}
