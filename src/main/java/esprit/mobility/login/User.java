package esprit.mobility.login;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String emailId;
    private String userName;
    private String password;
}
