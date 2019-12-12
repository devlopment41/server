package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.xml.crypto.Data;
@Entity
@Table(name = "medicine", schema = "server")
public class Medicine extends DBObject {
    @Name
    @GeneratedValue
    @Column(name = "name")
    private String name;
    @User_manual
    @GeneratedValue
    @Column(name = "user_manual")
    private String user_manual;
    @Price
    @GeneratedValue
    @Column(name = "price")
    private int price;
    @Side_effects
    @GeneratedValue
    @Column(name = "side_effects")
    private String side_effects;
    @Description
    @GeneratedValue
    @Column(name = "description")
    private String description;
    @Dosage
    @GeneratedValue
    @Column(name = "dosage")
    private int dosage;
    @Exp
    @GeneratedValue
    @Column(name = "exp")
    private Data exp;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_manual() {
        return user_manual;
    }

    public void setUser_manual(String user_manual) {
        this.user_manual = user_manual;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(String side_effects) {
        this.side_effects = side_effects;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public Data getExp() {
        return exp;
    }

    public void setExp(Data exp) {
        this.exp = exp;
    }


}
