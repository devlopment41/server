package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "actionCalls", schema = "server")
public class ActionCalls extends DBObject {

    @Issue
    @GeneratedValue
    @Column(name = "issue")
    private String issue;
    @Date
    @GeneratedValue
    @Column(name = "date")
    private Date date;
    @Description
    @GeneratedValue
    @Column(name = "description")
    private String description;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
