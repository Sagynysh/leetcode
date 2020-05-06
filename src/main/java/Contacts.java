import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {
    private Map<String, List<String>> contacts= new HashMap<>();
    public Contacts(){
    }

    public void addContacts(String name, String phone){
        if(contacts.containsKey(name)){
            contacts.get(name).add(phone);
        }else{
            contacts.put(name, Arrays.asList(phone));
        }
    }

    public String getContactsByName(String name){
        return Arrays.toString(contacts.get(name).toArray());
    }
}
