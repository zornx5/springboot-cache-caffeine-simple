package io.github.zornx5.simple.rest;

import io.github.zornx5.simple.entity.User;

import java.time.LocalDate;

public record UserRegisterRequest(String username,
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

    public User assignUser() {
        return User.builder()
                .username(this.username)
                .nickname(this.nickname)
                .description(this.description)
                .password(this.password)
                .avatar(this.avatar)
                .age(this.age)
                .sex(this.sex)
                .birthday(this.birthday)
                .phone(this.phone)
                .email(this.email)
                .address(this.address)
                .build();
    }

}
