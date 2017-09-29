import com.gs.bean.User;
import com.gs.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetByPhonePwd() {
        User user = userService.getByPhonePwd("13666666666", "123456");
        System.out.println(user);
    }
}
