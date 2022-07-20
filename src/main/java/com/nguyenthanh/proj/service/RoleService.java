package com.nguyenthanh.proj.service;

import com.nguyenthanh.proj.dto.request.RoleRequest;
import com.nguyenthanh.proj.dto.response.RoleResponse;

public interface RoleService {
    com.nguyenthanh.proj.dto.response.RoleResponse addRole (RoleRequest roleRequest) throws Exception;
}
