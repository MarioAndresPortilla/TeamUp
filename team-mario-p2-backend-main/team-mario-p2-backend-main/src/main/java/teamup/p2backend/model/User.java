package teamup.p2backend.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/*@JsonIdentityInfo(

        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "username1" //
)*/

@Entity
@Table(name="user1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id1;

    private String username1;

    @Column
    private String fullname1;
    @Column
    private String email1;
    @Column
    private String password1;

}