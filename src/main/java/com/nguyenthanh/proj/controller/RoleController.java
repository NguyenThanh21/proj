package com.nguyenthanh.proj.controller;

import com.nguyenthanh.proj.common.*;
import com.nguyenthanh.proj.dto.request.RoleRequest;
import com.nguyenthanh.proj.dto.response.*;
import com.nguyenthanh.proj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@RequestMapping("/api/auth/")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    JWTUtility jwtUtility;
    AuthenticationManager authenticationManager;

    @PostMapping("addRole")
    @ResponseBody
    public ResponseEntity addRole (@RequestBody RoleRequest roleRequest) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(roleRequest.getUsername(), roleRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtility.generateJwtToken(authentication);
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        RoleResponse roleResponse = roleService.addRole(roleRequest);
//        return ResponseEntity.ok(roleResponse);
        return null;
    }
}
