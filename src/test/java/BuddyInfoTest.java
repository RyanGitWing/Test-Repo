import AddressBookPkg.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo buddy = new BuddyInfo("Joe", "Ottawa", 666777888);

    @Test
    public void getName() {
        BuddyInfo buddy = new BuddyInfo("Joe", "Ottawa", 666777888);
        assertEquals(buddy.getName(), "Joe");
    }

    @Test
    public void getAddress() {
        assertEquals(buddy.getAddress(), "Ottawa");
    }

    @Test
    public void getNumber() {
        assertEquals(buddy.getPhoneNumber(), 666777888);
    }

}