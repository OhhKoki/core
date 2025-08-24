package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional  // 添加事务注解
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    @Transactional
    public int deleteUser(Long id) {
        return userMapper.logicDeleteById(id);
    }

    @Override
    public List<User> getUsersByNameAndAge(String name, Integer age) {
        return userMapper.selectByNameAndAge(name, age);
    }

    @Override
    public List<User> getUsersByCondition(User user) {
        return userMapper.selectByCondition(user);
    }

    @Override
    @Transactional
    public int batchAddUsers(List<User> users) {
        return userMapper.batchInsert(users);
    }

    @Override
    public List<User> getUsersByIds(List<Long> ids) {
        return userMapper.selectByIds(ids);
    }

    @Override
    public List<User> getUsersByPage(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return userMapper.selectByPage(offset, pageSize);
    }

    @Override
    public List<User> getUsersByMap(Map<String, Object> map) {
        return userMapper.selectByMap(map);
    }

    @Override
    public Long getUsersCount() {
        return userMapper.selectCount();
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    @Transactional
    public int updateUserWithVersion(User user) {
        return userMapper.updateWithVersion(user);
    }
}