package com.nguyenthanh.proj.service.impl;

import com.nguyenthanh.proj.dto.request.LoginRequest;
import com.nguyenthanh.proj.dto.response.UserResponse;
import com.nguyenthanh.proj.model.User;
import com.nguyenthanh.proj.repository.UserRepository;
import com.nguyenthanh.proj.service.UserService;
import com.nguyenthanh.proj.utils.PasswordEncryptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse addUser (LoginRequest loginRequest) throws Exception {
        UserResponse userResponse = new UserResponse();
        try {
            if (StringUtils.isEmpty(loginRequest.getUsername()) && StringUtils.isEmpty(loginRequest.getPassword())) {
                throw new Exception("Không được để trống!");
            }
            User user = new User();
            user.setUsername(loginRequest.getUsername());
            user.setPassword(PasswordEncryptions.encrypteBcryptPassword(loginRequest.getPassword()));
            userRepository.save(user);
            BeanUtils.copyProperties(user,userResponse);
            return userResponse;
        } catch (Exception e) {
            e.getLocalizedMessage();
            throw e;
        }
//        return null;
    }

    @Override
    public void deleteById (long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void changePass (User user, String newPass) {
        user.setPassword(passwordEncoder.encode(newPass));
        userRepository.save(user);
    }

}
