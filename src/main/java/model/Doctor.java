package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "doctor", schema = "server")
public class Doctor extends DBObject {
    @Name
    @GeneratedValue
    @Column(name = "name")
    private String name;
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
    @Activity_time
    @GeneratedValue
    @Column(name = "activity_time")
    private String activity_time;
    @Reception_days
    @GeneratedValue
    @Column(name = "reception_days")
    private String reception_days;
    @Language
    @GeneratedValue
    @Column(name = "language")
    private String language;
    @Field_treatment
    @GeneratedValue
    @Column(name = "field_treatment")
    private String field_treatment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getActivity_time() {
        return activity_time;
    }

    public void setActivity_time(String activity_time) {
        this.activity_time = activity_time;
    }

    public String getReception_days() {
        return reception_days;
    }

    public void setReception_days(String reception_days) {
        this.reception_days = reception_days;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getField_treatment() {
        return field_treatment;
    }

    public void setField_treatment(String field_treatment) {
        this.field_treatment = field_treatment;
    }


}
