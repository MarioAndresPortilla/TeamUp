package teamup.p2backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import teamup.p2backend.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User save(User user);


    List<User> findAll(); //probably don't need this for now

    User findById(int user_id);

    User findByUsername1(String username1);

    @Modifying
    @Query(value = "delete from user1 where user1.username1=:username1", nativeQuery = true)
    void deleteByUsername(String username1);

    //update(patch/put) method
    @Modifying
    @Query(value = "update user1 set user1.username1=:username1, user1.fullname1=:fullname1," +
            " user1.email1=:email1, user1.password1=:password1  where user1.user_id1=:user_id1", nativeQuery = true)
    void updateByUser(String username1, String fullname1, String email1, String password1, int user_id1);

}
