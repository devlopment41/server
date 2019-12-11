package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "actionRecommendation", schema = "server")
public class ActionRecommendation extends DBObject {
    @Reason
    @GeneratedValue
    @Column(name = "reason")
    private String reason;
    @Date
    @GeneratedValue
    @Column(name = "date")
    private Date date;
    @Kind
    @GeneratedValue
    @Column(name = "kind")
    private String kind;


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    private String kind;
}
