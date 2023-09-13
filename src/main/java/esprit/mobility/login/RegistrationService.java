package esprit.mobility.login;

import esprit.mobility.login.User;
import esprit.mobility.login.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;
    public User saveUser (User user){
        return repo.save(user);
    }

    public User fetchUserByEmailId(String email){
         return repo.findByEmailId(email);
    }

    public User fetchUserByEmailIdAndPassword(String email,String password){
        return repo.findByEmailIdAndPassword(email,password);
    }
}
