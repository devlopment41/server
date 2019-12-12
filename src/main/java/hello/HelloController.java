package hello;

//import com.db.dao.model.DoctorDAO;
import com.db.dao.model.UserDAO;
import com.model.Doctor;
import com.model.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user")
    @ResponseBody
    public  List<User> user() {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setId(2);
        dao.create(user);
       return dao.list();
    }
//    public  List<Doctor> doctor() {
//        DoctorDAO dao = new DoctorDAO();
//        Doctor doctor = new Doctor();
//        doctor.setId(2);
//        dao.create(doctor);
//        return dao.list();
//    }

}