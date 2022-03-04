package AddressBookPkg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {

    @Id
    private Integer id;

    private String name;

    private String address;

    private int phoneNumber;

    public BuddyInfo() {

    }

    /**
     *  Constructor for AddressBookPkg.BuddyInfo
     *
     * @param name of buddy
     * @param address of buddy
     * @param phoneNumber of buddy
     */
    public BuddyInfo(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    /**
     *  Getter function for buddy name.
     *
     * @return buddy name
     */
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    /**
     *  Getter function for buddy address.
     *
     * @return buddy address
     */
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;

    }

    /**
     *  Getter function for buddy phone number.
     *
     * @return buddy phone number
     */
    public int getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {

        this.phoneNumber = phoneNumber;

    }

    public static void main(String[] args) {

        BuddyInfo buddyinfo = new BuddyInfo("Homer", "Aylmer", 6138889);

        System.out.println( buddyinfo.getName() + "\n" +"Hello World!");

    }

}
