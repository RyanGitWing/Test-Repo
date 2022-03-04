package AddressBookPkg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class AddressBook {

    @Id
    private Integer id;

    @OneToMany
    private List<BuddyInfo> buddies;

    /**
     *  Constructor for AddressBookPkg.AddressBook.
     */
    public AddressBook() {

        buddies = new ArrayList<>();

    }

    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    /**
     *  Add buddy to address book.
     *
     * @param buddy to add
     */
    public void addBuddy(BuddyInfo buddy){

        if (buddy != null)
            buddies.add(buddy);


        System.out.println(buddy.getName());
        System.out.println(buddy.getAddress());
        System.out.println(buddy.getPhoneNumber());
    }

    /**
     * Remove a buddy from address book
     * @param buddy
     */
    public void removeBuddy(int buddy) {

        buddies.remove(buddy);

    }

    /**
     *  Getter function to retrieve info of Buddy.
     *
     * @param index of the buddy
     * @return AddressBookPkg.BuddyInfo is returned
     */
    public BuddyInfo getBuddyInfo(int index){

        return buddies.get(index);

    }

    public static void main(String[] args) {

        BuddyInfo buddy1 = new BuddyInfo("Jack", "Gatineau", 6134204);
        BuddyInfo buddy2 = new BuddyInfo("Laquifa", "Brampton", 819555);

        AddressBook book = new AddressBook();
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

    }

}
