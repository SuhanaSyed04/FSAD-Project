package com.jobportal.Job.Portal.entity;

import com.jobportal.Job.Portal.dto.Role;
import com.jobportal.Job.Portal.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Long profileID;

    public UserDTO toDTO()  {
        return new UserDTO(this.id,this.userName,this.password,this.email,this.phoneNumber,this.role,this.profileID);
    }
}
