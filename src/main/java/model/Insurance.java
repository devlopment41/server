package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "insurance", schema = "server")
public class Insurance extends DBObject {

    @Name
    @GeneratedValue
    @Column(name = "name")
    private String name;
    @Description
    @GeneratedValue
    @Column(name = "description")
    private String description;
    @Kind
    @GeneratedValue
    @Column(name = "kind")
    private String kind;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


}
