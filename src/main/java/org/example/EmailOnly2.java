package org.example;


// email sending with attachments :3

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class EmailOnly2 {

    private final JavaMailSender jms;

    public EmailOnly2(JavaMailSender jms) {
        this.jms = jms;
    }

    @Value("${app.mail.from}")
    private String from;


    // This Service only send plain Email with the text...
    public String sendMail() {
        log.info("Mail is Starting ..");
        try {
            MimeMessage msg = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg , true);
            helper.setFrom(from);
            helper.setTo("pirate7luffy@gmail.com");
            helper.setSubject("With Attachments");
            helper.setText("Check Image..");

            helper.addAttachment("Photo.jpg" ,new File("C:\\Users\\pirat\\source\\repos\\Carousel\\Pics\\2.jpg"));
            jms.send(msg);
            log.info("Mail has been forwarded to the User...");
            return "Success";
        } catch (Exception e) {
            log.error("Mail failed - reason: {}", e.getMessage());
            return "Fah";
        }
    }
}
