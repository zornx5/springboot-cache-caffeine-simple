package io.github.zornx5.simple.rest;

import io.github.zornx5.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户 Restful 资源
 *
 * @author zornx5
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserRestResource {

    private final UserService userService;

    @GetMapping("/users")
    public Collection<UserInfoResponse> findAll() {
        return UserInfoResponseAssembler.of(userService.findAll());
    }

    @GetMapping("/users/{username}")
    public Optional<UserInfoResponse> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username).map(UserInfoResponseAssembler::of);
    }

    @PostMapping("/users")
    public Optional<UserInfoResponse> register(@RequestBody UserRegisterRequest request) {
        return userService.save(request.assignUser()).map(UserInfoResponseAssembler::of);
    }

    @PatchMapping("/users/{username}")
    public Optional<UserInfoResponse> update(@PathVariable String username, @RequestBody UserUpdateRequest request) {
        return userService.update(username, request.assignUser()).map(UserInfoResponseAssembler::of);
    }

    @PostMapping("/users/batch")
    public Collection<UserInfoResponse> batchRegister(@RequestBody Collection<UserRegisterRequest> requests) {
        return UserInfoResponseAssembler.of(userService.saveAll(requests.stream()
                .map(UserRegisterRequest::assignUser).collect(Collectors.toSet())));
    }

    @DeleteMapping("/users")
    public void delete(@RequestBody UserDeleteRequest request) {
        userService.delete(request.assignUser());
    }

    @DeleteMapping("/users/all")
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/users/{username}")
    public void deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
    }

}
