import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static LinkedList<Notebook> data;

    public Cart()
    {
        data = new LinkedList<Notebook>();
    }

    public boolean add(Notebook nb)
    {
        if(nb.available)
        {
            data.addLast(nb);
            return true;
        } else {
            System.out.println(String.format("Model %s is unavailable now",nb.name));
            return false;
        }
    }

    public void print()
    {
        if (data.size()==0)
        {
            System.out.println("Корзина пуста");
        } else {
            double sum = 0.0;
            System.out.println("Ваша текущая корзина:");
            for(int i=0;i<data.size();i++)
            {
                sum += data.get(i).price;
                System.out.println(String.format("%s) %s (%s $)",i,data.get(i).name,data.get(i).price));
            }
            System.out.printf("Всего товаров на сумму %s$\n",sum);
        }
    }

}
