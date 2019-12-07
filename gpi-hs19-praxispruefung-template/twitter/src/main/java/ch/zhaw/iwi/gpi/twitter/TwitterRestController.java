package ch.zhaw.iwi.gpi.twitter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * TwitterRestController
 */
@RestController
public class TwitterRestController {
    

    @RequestMapping(value="/api/tweets", method=RequestMethod.POST)
    public ResponseEntity<Date> postTweet(@RequestBody Tweet tweet) {

        tweet.setPostedAt(new Date());

        twitterRepository.save(tweet);

        return new ResponseEntity<Date>(tweet.getPostedAt(),HttpStatus.CREATED);
       
    }
    

    
}