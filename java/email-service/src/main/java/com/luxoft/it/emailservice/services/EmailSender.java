package com.luxoft.it.emailservice.services;

import com.luxoft.it.emailservice.models.EmailDTO;
import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSender {

    public void send(EmailDTO emailDTO) throws IOException {
        Email from = new Email(emailDTO.getFrom());
        String subject = emailDTO.getSubject();
        Email to = new Email(emailDTO.getTo());
        Content content = new Content("text/plain", emailDTO.getBody());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
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
            throw ex;
        }
    }
}
