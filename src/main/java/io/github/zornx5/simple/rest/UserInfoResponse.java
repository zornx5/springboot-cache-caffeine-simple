package io.github.zornx5.simple.rest;

import java.time.LocalDate;

public record UserInfoResponse(String username,
                               String nickname,
                               String description,
                               String password,
                               String avatar,
                               Integer age,
                               String sex,
                               LocalDate birthday,
                               String phone,
                               String email,
                               String address) {
}
