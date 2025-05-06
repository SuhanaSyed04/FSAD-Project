package com.jobportal.Job.Portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id @GeneratedValue
    private Long id;
    private String jobTitle;
    private String company;
    private String duration;
    private String description;
}