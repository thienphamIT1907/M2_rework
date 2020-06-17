package com.qlkh_qlt.service.customer;


import com.qlkh_qlt.models.Customer;
import com.qlkh_qlt.models.Province;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
