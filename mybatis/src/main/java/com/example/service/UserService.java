package com.example.service;

import com.example.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Long id);
    List<User> getUsersByNameAndAge(String name, Integer age);
    List<User> getUsersByCondition(User user);
    int batchAddUsers(List<User> users);
    List<User> getUsersByIds(List<Long> ids);
    List<User> getUsersByPage(Integer pageNum, Integer pageSize);
    List<User> getUsersByMap(Map<String, Object> map);
    Long getUsersCount();
    List<User> getUsersByEmail(String email);
    int updateUserWithVersion(User user);
}