import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Random;

public class Store {
    private static Set<Notebook> data = new HashSet<Notebook>();
    private static HashMap<String, String> filterMap = new HashMap<String, String>();
    private static List<String> filters = Arrays.asList(new String[]{"minRAM","maxRAM","minHDD","maxHDD","minPerformance","maxPerformance","minPrice","maxPrice","Brand", "OS","Color","Available"});
    public Cart cart = new Cart();

    public void addNotebook(Notebook nb)
    {
        data.add(nb);
    }

    public Notebook getNotebook(String name)
    {
        for(Notebook nb:data)
        {
            if (nb.name.indexOf(name) != -1 || name.indexOf(nb.name) != -1) 
               return nb;
        }
        return null;
    }

    public void generate()
    {
        String[] brandnames = {"Toshiba","Asus","Acer","Lenovo","Macbook"};
        String[] colors = {"white","black","silver","colorful"};
        for(int i=0;i<101;i++)
        {
            int r = new Random(i).nextInt(brandnames.length);
            String brandname = brandnames[r];
            String os = (brandname == "Macbook")?"MacOs":"Windows";
            r = new Random().nextInt(colors.length);
            String color = colors[r];
            int RAM = new Random().nextInt(100000);
            int HDD  = new Random().nextInt(1000000000);
            double perf = new Random().nextDouble()*new Random().nextInt(10)+0.001;
            String name = String.format("%s%d",brandname, new Random().nextInt(10000));
            boolean available = new Random().nextBoolean();
            double price = ((double) (new Random().nextInt(100000) + 10000))/100;
            try {
                Notebook nb = new Notebook(name,brandname, RAM, HDD, perf, os, color, available,price);
                addNotebook(nb);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            clear_filter();
        }
    }

    public void listAll()
    {
        int i=0;
        for(Notebook nb:data)
        {
            System.out.println(String.format("%d) %s\n",i++,nb.info()));
        }
    }

    public void filteredList()
    {
        int i=0;
        for(Notebook nb:data)
        {
            if(filterMap.get("minRAM") != null)
                if(nb.RAM < Integer.parseInt(filterMap.get("minRAM"))) continue;
            if(filterMap.get("maxRAM") != null)
                if(nb.RAM > Integer.parseInt(filterMap.get("maxRAM"))) continue;
            if(filterMap.get("minHDD") != null)
                if(nb.HDD < Integer.parseInt(filterMap.get("minHDD"))) continue;
            if(filterMap.get("maxHDD") != null)
               if(nb.HDD > Integer.parseInt(filterMap.get("maxHDD"))) continue;
            if(filterMap.get("minPerformance")!=null)
                if(nb.CPU_perfomance < Double.parseDouble(filterMap.get("minPerformance"))) continue;
            if(filterMap.get("maxPerformance")!=null)
                if(nb.CPU_perfomance > Double.parseDouble(filterMap.get("maxPerformance"))) continue;
            if(filterMap.get("minPrice")!=null)
                if(nb.price < Double.parseDouble(filterMap.get("minPrice"))) continue;
            if(filterMap.get("maxPrice")!=null)
                if(nb.price > Double.parseDouble(filterMap.get("maxPrice"))) continue;
            if(filterMap.get("Brand")!=null)
                if(nb.brandname.indexOf(filterMap.get("Brand")) == -1 && filterMap.get("Brand").indexOf(nb.brandname) == -1) continue;
            if(filterMap.get("OS")!=null)
                if(nb.OS.indexOf(filterMap.get("OS")) == -1 && filterMap.get("OS").indexOf(nb.OS) == -1) continue;
            if(filterMap.get("Color")!=null)
                if(nb.Color.indexOf(filterMap.get("Color")) == -1 && filterMap.get("Color").indexOf(nb.Color) == -1) continue; 
            if(filterMap.get("Available")!=null)
                if(nb.available != (boolean) Boolean.parseBoolean(filterMap.get("Available"))) continue;                                       
            System.out.println(String.format("%d) %s\n",i++,nb.info()));
        }
    }

    public void filter(String property, String value)
    {
        System.out.println(String.format("%s = %s",property, value));
        if (filters.contains(property))
        {
            filterMap.put(property,value);
        } else {
            System.out.println("It's impossible to set that filter");
        }
        System.out.println(filterMap.get(property));
    }

    public void show_filter()
    {
        List<String> keys = new ArrayList<>(filterMap.keySet());
        for(String prop:keys)
        {
            System.out.println(String.format("Фильтр: %s = %s",prop,filterMap.get(prop)));
        }
    }

    public void clear_filter()
    {
        for(String prop:filters)
        {
            filterMap.put(prop,null);
        }
    }
}
