package melon.security.service;

import melon.security.mapper.UserMapper;
import melon.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中尝试读取该用户
        User user = userMapper.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 将逗号隔开的权限切割成可用权限对象列表
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));


        return user;
    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public boolean deleteUserByName(String username) {
        return userMapper.deleteUserByName(username);
    }
}
