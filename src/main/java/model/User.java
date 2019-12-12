package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", schema = "server")
public class User extends DBObject {


    @User_name
    @GeneratedValue
    @Column(name = "user_name")
    private String user_name;
    @Password
    @GeneratedValue
    @Column(name = "password")
    private int password;
    @Full_name
    @GeneratedValue
    @Column(name = "full_name")
    private String full_name;
    @Email
    @GeneratedValue
    @Column(name = "email")
    private String email;
    @Phone
    @GeneratedValue
    @Column(name = "phone")
    private int phone;
    @Address
    @GeneratedValue
    @Column(name = "address")
    private String address;
    @Gender
    @GeneratedValue
    @Column(name = "gender")
    private String gender;
    @Birth_date
    @GeneratedValue
    @Column(name = "birth_date")
    private Date birth_date;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }


}
