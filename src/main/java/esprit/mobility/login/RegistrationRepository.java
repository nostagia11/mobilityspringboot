package esprit.mobility.login;

import esprit.mobility.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User,Integer> {


    User findByEmailId(String email);


    User findByEmailIdAndPassword(String email,String password);
}
