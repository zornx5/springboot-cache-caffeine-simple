package io.github.zornx5.simple.service;

import io.github.zornx5.simple.entity.User;

import java.util.Collection;
import java.util.Optional;

/**
 * 用户服务
 *
 * @author zornx5
 */
public interface UserService {

    Collection<User> findAll();

    Optional<User> findByUsername(String username);

    Optional<User> save(User user);

    Optional<User> update(String username, User user);

    Collection<User> saveAll(Collection<User> users);

    void delete(User user);

    void deleteAll();

    void deleteByUsername(String username);

}
