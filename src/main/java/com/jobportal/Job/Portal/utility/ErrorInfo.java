package com.jobportal.Job.Portal.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;
}
