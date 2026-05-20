package org.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailScheduler {

    @Autowired
    public EmailOnly1 em;

    @Autowired
    public EmailOnly2 em2;


    @Scheduled(fixedRate=8000)
    public void tf2()
    {
        log.info("Email Task Occured...");
        String res = em2.sendMail();
        if(res.equals("Success"))
        {
            log.info("Success Happens Always");
        }
        else {
            log.info("Failed fah...");
        }
    }

    @Scheduled(fixedRate = 10000)
    public void tf()
    {
        log.info("Email Task Occured...");
        String res = em.sendMail();
        if(res.equals("Success"))
        {
            log.info("Success Happens Always");
        }
        else {
            log.info("Failed fah...");
        }
    }

}
