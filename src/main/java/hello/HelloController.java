package hello;

import com.db.dao.DBEntityDAO;
import com.db.dao.model.DoctorDAO;
import com.db.dao.model.UserDAO;
import com.model.Doctor;
import com.model.User;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<User> user() {
        UserDAO dao = new UserDAO();
        return dao.list();
    }





    @RequestMapping("/doctor")
    @ResponseBody
    public List<Doctor> newDoctors() {
        DBEntityDAO<Doctor, Integer> doctors = new DBEntityDAO<Doctor, Integer>() {};
        return doctors.list();
    }


    //    @RequestMapping("/login")
//    @ResponseBody
//    public boolean validateUser(@RequestParam("user_name") String userName, @RequestParam("password") String password) {
//        boolean x = true;
//        UserDAO dao = new UserDAO();
//        List<User> users = dao.list();
//        int intPassword = Integer.parseInt(password);
//        users = user();
//        return users;


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



//            return "userName: " + userName + " Password: " + password;
//       if(userName==user.us || password=="") {            return x;
//        }
//        else {return !x;}

    

