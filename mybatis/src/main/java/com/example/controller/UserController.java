package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result > 0 ? "添加成功" : "添加失败";
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        int result = userService.updateUser(user);
        return result > 0 ? "更新成功" : "更新失败";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        int result = userService.deleteUser(id);
        return result > 0 ? "删除成功" : "删除失败";
    }

    @GetMapping("/search")
    public List<User> getUsersByNameAndAge(@RequestParam String name,
                                           @RequestParam Integer age) {
        return userService.getUsersByNameAndAge(name, age);
    }

    @GetMapping("/condition")
    public List<User> getUsersByCondition(User user) {
        return userService.getUsersByCondition(user);
    }

    @PostMapping("/batch")
    public String batchAddUsers(@RequestBody List<User> users) {
        int result = userService.batchAddUsers(users);
        return result > 0 ? "批量添加成功，添加了 " + result + " 条记录" : "批量添加失败";
    }

    @GetMapping("/ids")
    public List<User> getUsersByIds(@RequestParam String ids) {
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::valueOf)
                .toList();
        return userService.getUsersByIds(idList);
    }

    @GetMapping("/page")
    public List<User> getUsersByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUsersByPage(pageNum, pageSize);
    }

    @GetMapping("/map")
    public List<User> getUsersByMap(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) Integer minAge,
                                    @RequestParam(required = false) Integer maxAge) {
        Map<String, Object> map = new HashMap<>();
        if (name != null) map.put("name", name);
        if (minAge != null) map.put("minAge", minAge);
        if (maxAge != null) map.put("maxAge", maxAge);
        return userService.getUsersByMap(map);
    }

    @GetMapping("/count")
    public Long getUsersCount() {
        return userService.getUsersCount();
    }

    @GetMapping("/email")
    public List<User> getUsersByEmail(@RequestParam String email) {
        return userService.getUsersByEmail(email);
    }

    @PutMapping("/version")
    public String updateUserWithVersion(@RequestBody User user) {
        int result = userService.updateUserWithVersion(user);
        return result > 0 ? "更新成功" : "更新失败，可能是版本号不一致或记录不存在";
    }
}