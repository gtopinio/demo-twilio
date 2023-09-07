package com.gtopinio.demotwilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SmsRequest {
    @NotNull
    private final String phoneNumber; // Destination number
    @NotNull
    private final String message;

    public SmsRequest(
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("message") String message
    ) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
}
