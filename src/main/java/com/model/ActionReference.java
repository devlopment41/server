package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "actionReference", schema = "server")
public class ActionReference extends DBObject {
    @GeneratedValue
    @Column(name = "kind")
    private String kind;
    @GeneratedValue
    @Column(name = "date")
    private Date date;
    @GeneratedValue
    @Column(name = "information")
    private String information;
    @GeneratedValue
    @Column(name = "reason")
    private String reason;
    @GeneratedValue
    @Column(name = "patient")
    private String patient;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

}
