package com.service.customer;

import com.models.Customer;
import com.models.Province;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
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
    public Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(name, pageable);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return null;
    }
}
