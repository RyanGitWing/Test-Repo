package AddressBookPkg;

import AddressBookPkg.Repository.AddressBookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository bookRepo;

    private AddressBook addressBook;

    @GetMapping("/")
    public String book(@RequestParam("id") Integer id, Model model) {

        model.addAttribute("addressbook", bookRepo.findById(id));
        return "addressbook";

    }

    @PostMapping("/")
    public AddressBook createAddressBook() {
        addressBook = new AddressBook();
        addressBook = bookRepo.save(addressBook);
        return addressBook;
    }

    @PostMapping("/")
    @ResponseBody
    public AddressBook addBuddy(@RequestParam("id") Integer id,@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phoneNumber") int phoneNumber) {

        addressBook = bookRepo.findById(id);
        BuddyInfo buddy = new BuddyInfo(name, address, phoneNumber);

        addressBook.addBuddy(buddy);
        bookRepo.save(addressBook);

        return addressBook;
    }

    @DeleteMapping("/")
    @ResponseBody
    public AddressBook removeBuddy(@RequestParam("id") Integer id, @RequestParam("buddyIndex") int buddyIndex) {

        addressBook = bookRepo.findById(id);

        addressBook.removeBuddy(buddyIndex);
        bookRepo.save(addressBook);

        return addressBook;
    }

}