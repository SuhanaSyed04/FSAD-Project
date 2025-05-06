package com.jobportal.Job.Portal.service;

import com.jobportal.Job.Portal.dto.LoginDTO;
import com.jobportal.Job.Portal.dto.ResponseDTO;
import com.jobportal.Job.Portal.dto.UserDTO;
import com.jobportal.Job.Portal.exception.JobPortalException;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO) throws JobPortalException;


    public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException;


    public void sendOtp(String email)throws Exception;

    public Boolean verifyOtp(String email, String otp)throws JobPortalException;

    ResponseDTO changePassword(LoginDTO loginDTO) throws JobPortalException;
}
