package ch.zhaw.gpi.prozessapplikation;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendDecisionDelegate
 */
@Named("sendDecisionAdapter")
public class SendDecisionDelegate {

    @Autowired
    private MailService mailService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String checkResult = (String) execution.getVariable("checkResult");
        String checkResultComment = (String) execution.getVariable("checkResultComment");
        String email = (String) execution.getVariable("eMail");
        String tweetContent = (String) execution.getVariable("tweetContent");
        String fullName = (String) execution.getVariable("fullName");

        String anredeKommabt = "Sehr geehrte Kommunikationsabteilungsmitarbeiter\n\n";
        String anredeMitarbeiter = "Hallo " + fullName + "\n\n";

        String subject;
        String bodyMain;

        if(checkResult.equals("rejected")){
            subject = "Tweet abgelehnt";
            bodyMain = "Die folgende Tweet-Anfrage wurde abgelehnt:\n" + tweetContent + "\nDie Begründung ist: " + checkResultComment;
        } else {
            subject = "Tweet veröffentlicht";
            bodyMain = "Die folgende Tweet-Anfrage wurde veröffentlicht:\n" + tweetContent;
        }

        mailService.sendMail("kommabt@firma.ch", subject, anredeKommabt + bodyMain + "\n\nIhre Prozessplattform");
        mailService.sendMail(email, subject, anredeMitarbeiter + bodyMain + "\n\nIhre Prozessplattform");
    }    
}