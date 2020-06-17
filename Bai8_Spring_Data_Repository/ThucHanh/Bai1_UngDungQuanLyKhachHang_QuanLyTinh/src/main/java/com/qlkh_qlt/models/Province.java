package com.qlkh_qlt.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_province")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Customer.class, mappedBy = "province")
    private List<Customer> customers;

    public Province() {
    }

    public Province(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}