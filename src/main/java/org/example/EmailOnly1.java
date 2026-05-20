package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
public class EmailOnly1 {

    private final JavaMailSender jms;

    public EmailOnly1(JavaMailSender jms) {
        this.jms = jms;
    }

    @Value("${app.mail.from}")
    private String from;


    // This Service only send plain Email with the text...
    public String sendMail() {
        log.info("Mail is Starting ..");
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setTo("pirate7luffy@gmail.com");
            msg.setSubject("Sending object-1");
            msg.setText("Launching is the first step after this idk:3.");

            jms.send(msg);
            log.info("Mail has been forwarded to the User...");
            return "Success";
        } catch (Exception e) {
            log.error("Mail failed - reason: {}", e.getMessage());
            e.printStackTrace(); // add this
            return "Fah";
        }
    }
}