package com.jobportal.Job.Portal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTP {

    @Id
    private String email;
    private String otpCode;
    @Column(name = "otp_creation_time")
    private LocalDateTime otpCreationTime;
}
