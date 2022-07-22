package com.nguyenthanh.proj.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ListUserResponse {
    List<UserResponse> userResponseList;
}
