package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "ActionTest", schema = "server")
public class ActionTest extends DBObject {

    @GeneratedValue
    @Column(name = "name")
    private  String name;
    @GeneratedValue
    @Column(name = "date")
    private Date date;
    @GeneratedValue
    @Column(name = "kind")
    private String kind;
    @GeneratedValue
    @Column(name = "reason")
    private String reason;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
