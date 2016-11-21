package net.objex.example.jaxrs;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mazharchoudhry on 2016-11-20.
 */
@Entity
@XmlRootElement
public class Product {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    int id;

    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }
}
