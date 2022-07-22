package com.nguyenthanh.proj.controller;

import com.nguyenthanh.proj.common.JWTUtility;
import com.nguyenthanh.proj.dto.PasswordDTO;
import com.nguyenthanh.proj.dto.request.LoginRequest;
import com.nguyenthanh.proj.dto.request.SignUpRequest;
import com.nguyenthanh.proj.dto.response.MessageResponse;
import com.nguyenthanh.proj.dto.response.ResponseObject;
import com.nguyenthanh.proj.dto.response.UserResponse;
import com.nguyenthanh.proj.model.User;
import com.nguyenthanh.proj.repository.UserRepository;
import com.nguyenthanh.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/auth/")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JWTUtility jwtUtility;
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("addUser")
    @ResponseBody
    public ResponseEntity addUser (@RequestBody LoginRequest loginRequest) throws Exception {
        try {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtUtility.generateJwtToken(authentication);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
            UserResponse userResponse = userService.addUser(loginRequest);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Full authentication is required to access this resource");
        }
    }

    @PutMapping("/updateUser")
    public ResponseObject updateUser (@RequestBody @Validated PasswordDTO dto, BindingResult result,
            HttpServletRequest request) {
        System.out.println(dto.toString());
        User currentUser = getSessionUser(request);

        ResponseObject ro = new ResponseObject();

        if (!passwordEncoder.matches(dto.getOldPassword(), currentUser.getPassword())) {
            result.rejectValue("oldPassword", "error.oldPassword", "Mật khẩu cũ không đúng");
        }

        if (!dto.getNewPassword().equals(dto.getConfirmNewPassword())) {
            result.rejectValue("confirmNewPassword", "error.confirmNewPassword", "Nhắc lại mật khẩu mới không đúng");
        }

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> errorsList = result.getFieldErrors();
            for (FieldError error : errorsList) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            ro.setErrorMessages(errors);
            ro.setStatus("fail");
            errors = null;
        } else {
            userService.changePass(currentUser, dto.getNewPassword());
            ro.setStatus("success");
        }

        return ro;
    }

    @GetMapping("/listUser")
    public ResponseEntity<Iterable<User>> listUser () throws Exception {
        //List<User> currentUser = userService.getAllUser();
        //ListUserResponse listUserResponse = userService.listUser();

        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser (@Validated @RequestBody SignUpRequest signupRequest, @PathVariable long id) {
        if (!userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is not already taken!"));
        }
//        User user = userRepository.findUserByUsername(signupRequest.getUsername());
//        user.setStatus(2);
        userRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }

    public User getSessionUser (HttpServletRequest request) {
        return (User) request.getSession().getAttribute("loggedInUser");
    }

}
