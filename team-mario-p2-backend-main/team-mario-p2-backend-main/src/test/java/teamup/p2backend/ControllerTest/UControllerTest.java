
package teamup.p2backend.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import teamup.p2backend.controller.UserController;
import teamup.p2backend.model.User;
import teamup.p2backend.repository.UserRepository;
import teamup.p2backend.service.UserService;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserRepository userRepository;

        @MockBean
        private UserService userService;

        private List<User> userList;

        @BeforeEach
        void setUp() {
            User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");
        }
    @Test
    public void saveTest() throws Exception {
        User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");
        Mockito.when(userService.saveUser(any(User.class))).thenReturn(sp1);
        this.mockMvc.perform(post("/user1")
                        .content("{\"user_id1\": 999, \"username1\": \"20DollarBill\", \"fullname1\": \"Billiam\", \"email1\": \"billiamWilliam@rocketmail\", \"password1\": \"password\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void getUser() throws Exception {
        Mockito.when(userService.findUserByUsername(any(String.class))).thenReturn(new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user1/username1/20DollarBill"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"user_id1\": 999, \"username1\": \"20DollarBill\", \"fullname1\": \"Billiam\", \"email1\": \"billaimWilliam@rocketmail\", \"password1\": \"password\"}"));
    }

    @Test
    public void delete() throws Exception {
        Mockito.when(userRepository.findByUsername1("20DollarBill")).thenReturn(new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password"));

        userRepository.deleteByUsername("20DollarBill");

        verify(userRepository, times(1)).deleteByUsername("20DollarBill");
    }

}
