package com.qlkh_qlt.service.customer;

import com.qlkh_qlt.models.Customer;
import com.qlkh_qlt.models.Province;
import com.qlkh_qlt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer = customerRepository.getOne(id);
        customerRepository.delete(customer);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return null;
    }
}
