package com.gtopinio.demotwilio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

    private final Service service; // Service -> TwilioSmsSender ~> SmsSender -> TwilioConfiguration

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        // For Angular, sending the request body as JSON is the default.
        Boolean returnValue = service.sendSms(smsRequest);
        // If the return value is true, then the SMS was sent successfully.
        // Thus, we can return a 200 OK response.
        // Otherwise, we can return a 400 Bad Request response.
        if (returnValue) {
            ResponseEntity.status(HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error sending SMS.");
        }

    }
}
