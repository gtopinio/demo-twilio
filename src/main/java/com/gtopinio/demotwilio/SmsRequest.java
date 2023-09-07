package com.gtopinio.demotwilio;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SmsRequest {
    private final String phoneNumber; // Destination number
    private final String message;

    public SmsRequest(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
