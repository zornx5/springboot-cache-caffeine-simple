package io.github.zornx5.simple.rest;

import io.github.zornx5.simple.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserInfoResponseAssembler {

    public static UserInfoResponse of(User user) {
        return new UserInfoResponse(
                user.getUsername(),
                user.getNickname(),
                user.getDescription(),
                user.getPassword(),
                user.getAvatar(),
                user.getAge(),
                user.getSex(),
                user.getBirthday(),
                user.getPhone(),
                user.getEmail(),
                user.getAddress()
        );
    }

    public static Collection<UserInfoResponse> of(Collection<User> users) {
        return users.stream().map(UserInfoResponseAssembler::of).collect(Collectors.toSet());
    }

}
