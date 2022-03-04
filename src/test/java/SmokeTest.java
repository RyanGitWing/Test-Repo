import static org.assertj.core.api.Assertions.assertThat;

import AddressBookPkg.AddressBookController;
import AddressBookPkg.Repository.AddressBookRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController addressBookController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(addressBookController).isNotNull();
    }
}