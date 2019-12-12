package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.xml.crypto.Data;
@Entity
@Table(name = "form", schema = "server")
public class Form extends DBObject {
    @Name
    @GeneratedValue
    @Column(name = "name")
    private String name;
    @Issue
    @GeneratedValue
    @Column(name = "issue")
    private String issue;
    @Fdata
    @GeneratedValue
    @Column(name = "fdata")
    private Data fdata;
    @Document_id
    @GeneratedValue
    @Column(name = "document_id")
    private int document_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Data getFdata() {
        return fdata;
    }

    public void setFdata(Data fdata) {
        this.fdata = fdata;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }
}
