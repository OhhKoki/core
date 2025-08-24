package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.entity.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    // 1. 查询所有用户
    List<User> selectAll();

    // 2. 根据ID查询用户
    User selectById(Long id);

    // 3. 插入用户
    int insert(User user);

    // 4. 更新用户
    int update(User user);

    // 5. 根据ID删除用户（物理删除）
    int deleteById(Long id);

    // 6. 根据ID逻辑删除用户
    int logicDeleteById(Long id);

    // 7. 根据姓名和年龄查询用户
    List<User> selectByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    // 8. 根据条件动态查询用户
    List<User> selectByCondition(User user);

    // 9. 批量插入用户
    int batchInsert(List<User> users);

    // 10. 根据ID列表查询用户
    List<User> selectByIds(List<Long> ids);

    // 11. 分页查询用户
    List<User> selectByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    // 12. 使用Map作为参数查询
    List<User> selectByMap(Map<String, Object> map);

    // 13. 查询用户总数
    Long selectCount();

    // 14. 根据邮箱查询用户（使用$符号示例，注意SQL注入风险）
    List<User> selectByEmail(@Param("email") String email);

    // 15. 使用乐观锁更新用户
    int updateWithVersion(User user);
}
