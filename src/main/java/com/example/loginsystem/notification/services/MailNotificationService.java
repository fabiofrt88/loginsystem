package com.example.loginsystem.notification.services;

import com.example.loginsystem.user.entities.User;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailNotificationService {

    @Autowired
    private Environment environment;

    public void sendActivationEmail(User user) throws IOException {

        SendGrid sendGrid = new SendGrid(environment.getProperty("apiKey"));

        Email from = new Email("fabiofra88@hotmail.it");
        Email to = new Email(user.getEmail());
        String subject = "Ti sei iscritto alla piattaforma";
        String text = "Il codice di attivazione è: " + user.getActivationCode();
        Content content = new Content("text/plain", text);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sendGrid.api(request);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
    }
}
