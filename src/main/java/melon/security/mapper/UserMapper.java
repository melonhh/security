package melon.security.mapper;

import melon.security.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("Select * from users where username=#{username}")
    User findByUserName(@Param("username") String username);

    @Insert("insert into users(username, password, roles) values(#{user.username}, #{user.password}, #{user.roles})")
    boolean addUser(@Param("user") User user);

    @Delete("delete from users where username = #{username}")
    boolean deleteUserByName(@Param("username") String username);
}
