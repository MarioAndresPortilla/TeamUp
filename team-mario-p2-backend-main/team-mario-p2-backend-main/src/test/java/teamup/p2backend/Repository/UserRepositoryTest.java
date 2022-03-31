package teamup.p2backend.Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teamup.p2backend.model.User;
import teamup.p2backend.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void TestCase() {
        User sp1 = new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password");
        userRepository.save(sp1);
        List<User> userList = Arrays.asList(
                new User(999,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password"),
                new User(998,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password"));
        userRepository.saveAll(userList);
    }

    @AfterEach
    public void remove() {
        userRepository.deleteAll();
    }

    @Test
    void saveAll() {
        List<User> userList = Arrays.asList(
                new User(999,"21DollarBill","Billiam", "billaimWilliam@rocketmail","password"),
                new User(998,"20DollarBill","Billiam", "billaimWilliam@rocketmail","password")

                );

        Iterable<User> allUser = userRepository.saveAll(userList);

        AtomicInteger validIdFound = new AtomicInteger();
        allUser.forEach(user -> {
                    if (user.getUsername1().matches("20DollarBill|21DollarBill")) {
                        validIdFound.getAndIncrement();

                    }

                });
            assertThat(validIdFound.intValue()).isEqualTo(2);
       }

        @Test
        void findAll(){
            List<User> allUser = userRepository.findAll();
            assertThat(allUser.size()).isGreaterThanOrEqualTo(1);
        }
    }
