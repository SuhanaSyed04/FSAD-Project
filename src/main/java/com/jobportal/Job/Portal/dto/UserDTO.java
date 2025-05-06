package com.jobportal.Job.Portal.dto;

import com.jobportal.Job.Portal.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long id;

    @NotBlank(message = "{userDTO.userName.notBlank}")
    private String userName;
    @NotBlank(message = "{userDTO.password.notBlank}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character"
    )
    private String password;
    @NotBlank(message = "{userDTO.email.notBlank}")
    @Email(message = "{userDTO.email.invalid}")
    private String email;
    @NotBlank(message = "{userDTO.phoneNumber.notBlank}")
    private String phoneNumber;
    private Role role;

    private Long profileID;

    public User toEntity()  {
        return new User(this.id,this.userName,this.password,this.email,this.phoneNumber,this.role,this.profileID);
    }
}
