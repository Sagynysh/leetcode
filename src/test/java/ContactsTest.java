import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {
    private static Contacts contacts;
    @BeforeAll
    public static void initClass(){
        contacts = new Contacts();
    }

    @Test
    public void addContacts(){
        contacts.addContacts("Steve","8778");
        assertEquals("[8778]",contacts.getContactsByName("Steve"));
    }

//    @Test
//    public void getContacts(){
//        assertEquals("[8778]",contacts.getContactsByName("Steve"));
//    }

}