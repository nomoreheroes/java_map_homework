import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Phonebook {

    private static HashMap <String,LinkedList<String>> data = new HashMap<String, LinkedList<String>>();

    public void printAllPhones()
    {
        printAllPhones(false);
    }

    public void printAllPhones(boolean reverse)
    {
        List<String> keys = new ArrayList<>(data.keySet());
        Collections.sort(keys,new Comparator<String>(){
            public int compare(String key1, String key2)
            {
                if (reverse == false)
                {
                    return data.get(key1).size()-data.get(key2).size();
                } else {
                    return data.get(key2).size()-data.get(key1).size();
                }
            }
        });
        for(String user:keys)
        {
            System.out.println(String.format("Контакт: %s\nНомера телефонов:",user));
            LinkedList<String> phones = data.get(user);
            for(int i=0;i<phones.size();i++)
            {
                System.out.println(String.format("\t%d) %s",i, phones.get(i)));
            }
        }
    }

    public void addNewPhone(String user, String number)
    {
        if(data.containsKey(user))
        {
            LinkedList<String> phones = data.get(user);
            phones.addLast(number);
        } else {
            LinkedList<String> phones = new LinkedList<String>();
            phones.addLast(number);
            data.put(user, phones);
        }
    }

    public LinkedList<String> getPhonesByUser(String user)
    {
        LinkedList<String> rs = new LinkedList();
        return rs;
    }
    
    public void printPhonesByUser(String user)
    {
        LinkedList<String> rs = data.get(user);
        System.out.println(String.format("Контакт: %s\nНомера телефонов:",user));
        for(int i=0;i<rs.size();i++)
        {
            System.out.println(String.format("\t%d) %s",i, rs.get(i)));
        }
    }
}
