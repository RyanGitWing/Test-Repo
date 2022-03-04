import AddressBookPkg.AddressBook;
import AddressBookPkg.BuddyInfo;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersistTest {

    @Test
    public void PersistBuddyInfo(){

        BuddyInfo buddyInfo1 = new BuddyInfo();
        buddyInfo1.setId(1);
        buddyInfo1.setName("John");
        buddyInfo1.setAddress("Ottawa");
        buddyInfo1.setPhoneNumber(789789);

        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setId(2);
        buddyInfo2.setName("Lee");
        buddyInfo2.setAddress("Gatineau");
        buddyInfo2.setPhoneNumber(123123);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyInfo1);
        em.persist(buddyInfo2);

        tx.commit();

        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        //@SuppressWarnings("unchecked");
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddyinfos\n------------------------");

        for (BuddyInfo b: results) {

            System.out.println(b.getName() + "(id = " + b.getId() + ")");

        }

        assert(results.contains(buddyInfo1));
        assert(results.contains(buddyInfo2));

        em.close();

        emf.close();

    }

    @Test
    public void PersistAddressBook(){

        BuddyInfo buddyInfo1 = new BuddyInfo();
        buddyInfo1.setId(1);
        buddyInfo1.setName("John");
        buddyInfo1.setAddress("Ottawa");
        buddyInfo1.setPhoneNumber(789789);

        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setId(2);
        buddyInfo2.setName("Lee");
        buddyInfo2.setAddress("Gatineau");
        buddyInfo2.setPhoneNumber(123123);

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyInfo1);
        em.persist(buddyInfo2);

        addressBook.addBuddy(buddyInfo1);
        addressBook.addBuddy(buddyInfo2);

        em.persist(addressBook);

        tx.commit();

        Query q = em.createQuery("SELECT a FROM AddressBook a");

        //@SuppressWarnings("unchecked");
        List<AddressBook> results = q.getResultList();

        System.out.println("List of addressbooks\n------------------------");

        for (AddressBook a: results) {

            System.out.println("(id = " + a.getId() + ")");

        }

        assertEquals(results.get(0).getBuddyInfo(0).getName(), buddyInfo1.getName());
        assertEquals(results.get(0).getBuddyInfo(1).getName(), buddyInfo2.getName());

        em.close();

        emf.close();

    }

}
