package hello;

import com.db.dao.model.UserDAO;
import com.model.User;
import org.hibernate.sql.Select;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class Login {
//    boolean x;
//    @RequestMapping("/login")
//    @ResponseBody
//    public boolean validateUser(@RequestParam("user_name") String userName,
//                                @RequestParam("password") String password) {
//
//    }
//        UserDAO dao = new UserDAO();
//        List<User> users = dao.list();
//        int intPassword = Integer.parseInt(password);
//
//        for (int i = 0; i < users.size(); i++) {
//
//            if (userName == users.get(i).getUser_name() || intPassword == users.get(i).getPassword()) {
//                x = true;
//            } else {
//                System.out.println(users.get(i).getUser_name());
//                System.out.println(users.get(i).getPassword());
//                System.out.println(userName);
//                System.out.println(intPassword);
//                x = false;
//            }
//            return x;
//        }
//
//        return x;
//    }
}

