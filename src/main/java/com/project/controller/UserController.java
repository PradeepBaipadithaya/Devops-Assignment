import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.UserDao;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user/count")
    public String getUserCount() {
        int count = userDao.getUserCount();
        return "Total number of users: " + count;
    }
}
