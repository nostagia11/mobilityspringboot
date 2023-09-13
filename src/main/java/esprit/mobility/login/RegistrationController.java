package esprit.mobility.login;


import esprit.mobility.login.User;
import esprit.mobility.login.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController

public class RegistrationController {
    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }
        @PostMapping ("/registeruser")
        public User registerUser(@RequestBody User user) throws Exception{
        String tempEmailId = user.getEmailId();
        if (tempEmailId!=null && !"".equals(tempEmailId)){
            User userobj =service.fetchUserByEmailId(tempEmailId);
            if (userobj!=null){
                throw new Exception("user with "+tempEmailId+" already exists");
            }


        }
        User userobj= null;
        userobj=service.saveUser(user);
        return userobj;


    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId= user.getEmailId();
        String tempPass= user.getPassword();
        User userobj=null;
        if (tempEmailId!=null && tempPass!=null){
            userobj=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }
        if(userobj==null){
            throw new Exception("Bad Credentials");
        }
        return userobj;

    }
}
