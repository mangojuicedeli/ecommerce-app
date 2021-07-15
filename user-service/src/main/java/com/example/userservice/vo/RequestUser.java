package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull(message = "이메일은 반드시 입력해야합니다.")
    @Size(min = 2, message = "이메일은 2자리 이상을 입력해야합니다.")
    @Email
    private String email;

    @NotNull(message = "이름은 반드시 입력해야합니다.")
    @Size(min = 2, message = "이름은 2자리 이상을 입력해야합니다.")
    private String name;

    @NotNull(message = "비밀번호는 반드시 입력해야합니다.")
    @Size(min = 8, message = "비밀번호는 8자리 이상을 입력해야합니다.")
    private String pwd;
}
