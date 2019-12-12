package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actionMedicine", schema = "server")
public class ActionMedicine extends DBObject {
}
