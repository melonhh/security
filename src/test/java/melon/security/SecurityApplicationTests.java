package melon.security;

import melon.security.model.User;
import melon.security.service.MyUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityApplicationTests {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("melon");
        String password = new BCryptPasswordEncoder().encode("dwj123##");
        user.setPassword(password);
        user.setRoles("ROLE_USER");

        myUserDetailsService.addUser(user);
    }

}
