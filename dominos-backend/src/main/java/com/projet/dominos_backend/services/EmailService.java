package com.projet.dominos_backend.services;

import com.sendgrid.helpers.mail.*;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.SendGrid;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.Method;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    private final Email fromEmail = new Email("ismablaise@gmail.com");

    public void sendVerificationEmail(String to, String code) {
        String subject = "Code de vérification";
        String content = "Votre code de vérification est : " + code;

        Email toEmail = new Email(to);
        Content emailContent = new Content("text/plain", content);

        Mail mail = new Mail(fromEmail, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw new RuntimeException("Failed to send email", ex);
        }
    }
}