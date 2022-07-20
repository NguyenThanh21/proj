package com.nguyenthanh.proj.dto.request;

import com.nguyenthanh.proj.model.Role;
import lombok.Data;

@Data
public class RoleRequest extends Role {
    private String username;
    private String password;
}
