package hello;

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
    public String user() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        return session.get(User.class,1).toString();
    }

}