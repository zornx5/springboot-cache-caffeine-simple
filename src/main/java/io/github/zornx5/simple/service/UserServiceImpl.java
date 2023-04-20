package io.github.zornx5.simple.service;

import io.github.zornx5.simple.entity.User;
import io.github.zornx5.simple.exception.UsernameNotFoundException;
import io.github.zornx5.simple.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Optional;

/**
 * 用户服务实现
 *
 * @author zornx5
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        log.info("查找全部");
        return userRepository.findAll();
    }

    @Cacheable(value = "user", key = "'user'.concat(#username)")
    @Override
    public Optional<User> findByUsername(String username) {
        log.info("根据用户名查找");
        return userRepository.findByUsername(username);
    }

    @Cacheable(value = "user", key = "'user'.concat(#user.username)")
    @Override
    public Optional<User> save(User user) {
        log.info("保存用户");
        Assert.notNull(user, "要保存的用户不能为空");
        Assert.notNull(user, "要保存的用户不能为空");
        return userRepository.save(user);
    }

    @CachePut(value = "user", key = "'user'.concat(#username)")
    @Override
    public Optional<User> update(String username, User user) {
        log.info("更新用户");
        Assert.notNull(username, "要更新的用户名不能为空");
        Assert.notNull(user, "要更新的用户不能为空");
        User updateUser = userRepository.findByUsername(username).orElseThrow(UsernameNotFoundException::new);
        BeanUtils.copyProperties(user, updateUser, "username");
        return userRepository.save(updateUser);
    }

    @Override
    public Collection<User> saveAll(Collection<User> users) {
        log.info("批量保存用户");
        Assert.notEmpty(users, "要保存的用户集合不能为空");
        return userRepository.saveAll(users);
    }

    @CacheEvict(value = "user", key = "'user'.concat(#user.username)")
    @Override
    public void delete(User user) {
        log.info("删除用户");
        Assert.notNull(user, "要删除的用户不能为空");
        userRepository.delete(user);
    }

    @Override
    public void deleteAll() {
        log.info("批量删除用户");
        userRepository.deleteAll();
    }

    @CacheEvict(value = "user", key = "'user'.concat(#username)")
    @Override
    public void deleteByUsername(String username) {
        log.info("根据用户名删除用户");
        Assert.notNull(username, "要删除的用户名不能为空");
        userRepository.deleteByUsername(username);
    }

}
