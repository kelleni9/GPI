package ch.zhaw.iwi.gpi.userservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * UserRestController
 */
@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository; 

    @RequestMapping(value="/userapi/v1/users/{userName}", method=RequestMethod.GET)
    public ResponseEntity<User> getUser(String userName) {
        Optional<User> user = userRepository.findById(userName);


        try {
            return new ResponseEntity <> (user.get(), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        
    }
    

    
}