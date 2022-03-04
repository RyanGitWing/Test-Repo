import AddressBookPkg.BuddyInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/**
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    private BuddyInfo buddy = new BuddyInfo("Bart", "580 Elgin Street", 6667778);

    public ApplicationTest() {
    }

    @BeforeAll
    public void testAddBuddyInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/addressbook/", new Object[0]).content("{}").contentType(MediaType.APPLICATION_JSON).accept(new MediaType[]{MediaType.APPLICATION_JSON})).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/addressbook/1", new Object[0]).content(this.mapper.writeValueAsString(this.buddy)).contentType(MediaType.APPLICATION_JSON).accept(new MediaType[]{MediaType.APPLICATION_JSON})).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Bart")));
    }

    @Test
    public void testGetBuddyInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/addressbook/1", new Object[0])).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Bart")));
    }

    @AfterAll
    public void testRemoveBuddyInfo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/addressbook/1", new Object[0]).content(this.mapper.writeValueAsString(this.buddy)).contentType(MediaType.APPLICATION_JSON).accept(new MediaType[]{MediaType.APPLICATION_JSON})).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.not(Matchers.containsString("Bart"))));
    }
}
*/