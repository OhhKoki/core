package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        User user = new User("测试用户", 25, "test@example.com");
        int result = userService.addUser(user);
        System.out.println("添加结果: " + result + ", 用户ID: " + user.getId());
    }

    @Test
    public void testBatchAddUsers() {
        List<User> users = Arrays.asList(
                new User("用户1", 20, "user1@example.com"),
                new User("用户2", 22, "user2@example.com"),
                new User("用户3", 24, "user3@example.com")
        );
        int result = userService.batchAddUsers(users);
        System.out.println("批量添加结果: " + result);
    }

    @Test
    public void testUpdateUser() {
        User user = userService.getUserById(1L);
        if (user != null) {
            user.setName("修改后的姓名");
            int result = userService.updateUser(user);
            System.out.println("更新结果: " + result);
        }
    }

    @Test
    public void testLogicDelete() {
        int result = userService.deleteUser(1L);
        System.out.println("逻辑删除结果: " + result);
    }

    @Test
    public void testSelectByCondition() {
        User condition = new User();
        condition.setName("张");
        condition.setAge(20);
        List<User> users = userService.getUsersByCondition(condition);
        users.forEach(System.out::println);
    }
}