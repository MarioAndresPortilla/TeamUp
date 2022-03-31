package teamup.p2backend.ServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import teamup.p2backend.controller.UserController;
import teamup.p2backend.model.User;
import teamup.p2backend.repository.UserRepository;
import teamup.p2backend.service.UserService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;


    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    public void saveTest() {
        User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");

        userService.saveUser(sp1);

        verify(userRepository, times(1)).save(sp1);

    }

    @Test
    public void findTest() {
        User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");

        userService.saveUser(sp1);
        userService.findUserByUsername("20DollarBill");
        verify(userRepository, times(1)).findByUsername1("20DollarBill");

    }

    @Test
    public void deleteTest() {
        User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");

        userService.saveUser(sp1);
        userService.deleteUser("20DollarBill");
        verify(userRepository, times(1)).deleteByUsername("20DollarBill");
    }
}

