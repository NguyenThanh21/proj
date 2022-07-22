package com.nguyenthanh.proj.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Data
@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private Set<String> role;
}
