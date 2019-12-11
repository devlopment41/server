package hello;

import com.db.dao.model.UserDAO;
import com.db.model.HibernateUtil;
import com.db.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user")
    public int user() {

        UserDAO dao = new UserDAO();
        User user = new User();
        user.setId(2);
        dao.create(user);
       return dao.list().toArray().length;
    }

}