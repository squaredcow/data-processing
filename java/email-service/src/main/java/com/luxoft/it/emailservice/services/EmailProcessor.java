package com.luxoft.it.emailservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.it.emailservice.models.EmailDTO;
import com.luxoft.it.emailservice.services.consumers.IConsumer;
import com.luxoft.it.emailservice.services.producers.IProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class EmailProcessor implements IConsumer<String>, IProducer<String> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private EmailSender emailSender;

    @Override
    @KafkaListener(topics = "emails", groupId = "email.consumer")
    public void consume(String message) {
        EmailDTO email = new EmailDTO();
        try {
            email = objectMapper.readValue(message, EmailDTO.class);
        } catch (JsonProcessingException jpe) {
            // Todo:
        }
        System.out.println(email.toString());

        // Logic of sending the email
        try {
            emailSender.send(email);
        }catch(IOException ioe) {
            log.error("error while sending the email", ioe);
        }

        // Publish status
        produce("Status: SUCCESS");
    }

    @Override
    public void produce(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>("status", message);
        // send() is Async
        // kafkaTemplate.send(record);
        try {
            kafkaTemplate.send(record).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
