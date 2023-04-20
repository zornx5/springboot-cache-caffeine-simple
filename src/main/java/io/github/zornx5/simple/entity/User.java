package io.github.zornx5.simple.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * 用户实体
 *
 * @author zornx5
 */
@Data
@Builder
public class User {

    private String username;

    private String nickname;

    private String description;

    private String password;

    private String avatar;

    private Integer age;

    private String sex;

    private LocalDate birthday;

    private String phone;

    private String email;

    private String address;

}
