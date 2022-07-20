package com.nguyenthanh.proj.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private Set<String> role;
}
