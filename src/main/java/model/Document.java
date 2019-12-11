package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "document", schema = "server")
public class Document extends DBObject {

    @Name
    @GeneratedValue
    @Column(name = "name")
    private String name;
    @Path
    @GeneratedValue
    @Column(name = "path")
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
