package ch.zhaw.gpi.prozessapplikation;

import org.springframework.stereotype.Component;

/**
 * MailService
 */
@Component
public class MailService {

    public void sendMail(String to, String subject, String body){
        System.out.println("########### BEGIN MAIL ##########################");
        System.out.println("############################### Mail-Subjekt: " + subject);
        System.out.println("############################### Mail-Empfänger: " + to);
        System.out.println(Body);
        System.out.println("########### END MAIL ############################");
    }
}