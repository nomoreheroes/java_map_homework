import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Спасибо, что заглянули в наш интернет-магазин ноутбуков!");
        System.out.println("Что желаете?");
        System.out.println("Введите команду \"list\", чтобы получить весь список наших ноутбуков");
        System.out.println("Введите команду \"filter filtername filtervalue\", чтобы установать фильтр для выборки. Типы фильтров: \"minRAM\" (целое число),\"maxRAM\"(целое число),\"minHDD\"(целое число),\"maxHDD\"(целое число),\"minPerformance\"(действительное число),\"maxPerformance\"(действительное число),\"minPrice\"(действительное число),\"maxPrice\"(действительное число)\"Brand\" (стока), \"OS\" (строка),\"Color\" (строка),\"Available\"(true или false).  Пример: filter OS Windows\n Будьте внимательны при указании названий фильтров");
        System.out.println("Введите команду \"filter\", чтобы вывести на экран все текущие фильтры");
        System.out.println("Введите команду \"clearfilter\", чтобы очистить все фильтры");
        System.out.println("Веедите команду \"search\", чтобы вывести отфильтрованный список"); 
        System.out.println("Веедите команду \"addcart name\", чтобы добавить ноутбук в корзину для покупки"); 
        System.out.println("Введите команду \"stop\", чтобы закрыть приложение");

        Store store = new Store();
        store.generate();

        while(true)
        {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.indexOf("list") == 0) {
                System.out.println("Список ноутбуков в продаже:\n");
                store.listAll();
            } else if (command.indexOf("filter")==0) {
                String[] params = command.split("\\s+");
                if(params.length >= 3)
                {
                    String filtername = params[1];
                    String filtervalue = params[2];
                    store.filter(filtername,filtervalue);
                }
                System.out.println("Текущие установленные фильтры:");
                store.show_filter();
            } else if(command.indexOf("clearfilter")==0) {
                    store.clear_filter();
                    store.show_filter();
            } else if(command.indexOf("search")== 0) {
                System.out.println("Список ноутбуков в продаже (отфильтрованный):\n");
                store.filteredList();
            } else if(command.indexOf("addcart")== 0) {
                String[] params = command.split("\\s+");
                String name = params[1];
                Notebook nb = store.getNotebook(name);
                nb.Select(store.cart);           
            } else if(command.indexOf("stop") != -1) {
                in.close();
                break;
            } 
        }
    }
}
