package com.jobportal.Job.Portal.repository;

import com.jobportal.Job.Portal.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OTPRepository extends JpaRepository<OTP, String> {

    Optional<OTP> findByEmail(String email);

    List<OTP> findByOtpCreationTimeBefore(LocalDateTime expiryTime);
}
