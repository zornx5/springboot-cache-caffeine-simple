package io.github.zornx5.simple.repository;

import io.github.zornx5.simple.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 用户仓储
 *
 * @author zornx5
 */
@Repository
public class UserRepository {

    private final Map<String, User> users = new ConcurrentHashMap<>(16);

    public Collection<User> findAll() {
        return new HashSet<>(this.users.values());
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(this.users.get(username));
    }

    public Optional<User> save(User user) {
        this.users.put(user.getUsername(), user);
        return Optional.ofNullable(this.users.get(user.getUsername()));
    }

    public Collection<User> saveAll(Collection<User> users) {
        users.forEach(user -> this.users.put(user.getUsername(), user));
        return users.stream().map(user -> this.users.get(user.getUsername())).collect(Collectors.toList());
    }

    public void delete(User user) {
        this.users.remove(user.getUsername());
    }

    public void deleteAll() {
        this.users.clear();
    }

    public void deleteByUsername(String username) {
        this.users.remove(username);
    }

}
