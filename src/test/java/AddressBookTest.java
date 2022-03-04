import AddressBookPkg.AddressBook;
import AddressBookPkg.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook book;
    private BuddyInfo buddyInfo1;
    private BuddyInfo buddyInfo2;

    @Test
    public void addBuddy() {

        book = new AddressBook();
        buddyInfo1 = new BuddyInfo("Homer", "Aylmer", 6138889);
        buddyInfo2 = new BuddyInfo("Dan", "Toronto", 8192229);
        book.addBuddy(buddyInfo1);
        book.addBuddy(buddyInfo2);
        assertEquals(book.getBuddyInfo(0).getName(), "Homer");
        assertEquals(book.getBuddyInfo(1).getName(), "Dan");

    }

}