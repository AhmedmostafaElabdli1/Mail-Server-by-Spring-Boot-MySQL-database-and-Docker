package com.mail.main.Controller;

import com.mail.main.Entity.Mail;
import com.mail.main.Service.MailService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping("")
    public String mail(){
        return "Hello";
    }
    @PostMapping("/send")
    public void sendMail(@RequestBody Mail mailRequest) {
        System.out.println(mailRequest.getMailRecipient());
        mailService.sendMail(mailRequest.getMailRecipient(), mailRequest.getSubject(), mailRequest.getBody());
    }



}
