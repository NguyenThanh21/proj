package com.nguyenthanh.proj.service;

import com.nguyenthanh.proj.dto.request.LoginRequest;
import com.nguyenthanh.proj.dto.response.UserResponse;
import com.nguyenthanh.proj.model.User;

public interface UserService {
    UserResponse addUser (LoginRequest loginRequest) throws Exception;

    void deleteById (long id);

    void changePass (User user, String newPass);
}
