import java.util.Scanner;

public class Main {

    private static Phonebook book = new Phonebook();

    public static void main(String[] args)
    {
        System.out.println("Спасибо, что заглянули в нашу телефонную книгу!");
        System.out.println("Что желаете?");
        System.out.println("Введите команду \"add\", чтобы добавить номер телефона. (Пример: add Вася Пупкин 1112233)");
        System.out.println("Введите команду \"find\", чтобы найти все номера телефона контактного лица. (Пример: find Вася Пупкин)");
        System.out.println("Введите команду \"print\", чтобы напечатать все номера из телефонной книги. (Пример: print). По умолчанию все пользователи отсортированы по количеству телефонов");
        System.out.println("Введите команду \"print\", чтобы напечатать все номера из телефонной книги в обратном порядке. (Пример: print)");
        System.out.println("Введите команду \"stop\", чтобы закрыть телефонную книгу");

        while(true)
        {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.indexOf("add") == 0) {
                String[] vars = command.split("\\s+",3);
                String name = vars[1];
                String number = vars[2];
                book.addNewPhone(name, number);
            } else if (command.indexOf("print")==0 && command.indexOf("reverse") == -1) {
                book.printAllPhones();
            } else if(command.indexOf("stop") != -1) {
                System.out.println("Cao!");
                break;
            } else if (command.indexOf("print reverse")==0) {
                book.printAllPhones(true);
            } else if (command.indexOf("find")==0) {
                String[] vars = command.split("\\s+",2);
                String name = vars[1];
                book.printPhonesByUser(name);
            }
        }
    }
}
