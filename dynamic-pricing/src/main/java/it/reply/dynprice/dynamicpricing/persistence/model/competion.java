package it.reply.dynprice.dynamicpricing.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class competion {

    private Long id;
    private Double price;

    public String getCompetion() {
        return Competion;
    }

    public void setCompetion(String competion) {
        Competion = competion;
    }

    private String Competion;

    private Date updated;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setId(Long id) {
        this.id = id;
    }





}
