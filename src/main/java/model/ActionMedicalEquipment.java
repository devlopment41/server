package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "actionMedicalEquipment", schema = "server")
public class ActionMedicalEquipment extends DBObject {
    @Name
    @GeneratedValue
    @Column(name = "name")
    private  String name;
    @Price
    @GeneratedValue
    @Column(name = "price")
    private int price;
    @IsRenting
    @GeneratedValue
    @Column(name = "isRenting")
    private boolean isRenting;
    @IsSale
    @GeneratedValue
    @Column(name = "isSale")
    private boolean isSale;
    @Exp
    @GeneratedValue
    @Column(name = "exp")
    private Date exp;
    @Information
    @GeneratedValue
    @Column(name = "information")
    private  String information;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRenting() {
        return isRenting;
    }

    public void setRenting(boolean renting) {
        isRenting = renting;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


}
