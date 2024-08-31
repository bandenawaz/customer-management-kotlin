package com.example.customer_management.service

import com.example.customer_management.model.Customer
import com.example.customer_management.repoistory.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    fun getCustomerById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    fun createCustomer(customer: Customer) : Customer = customerRepository.save(customer)

    fun updateCustomer(id: Long, newCustomer: Customer): Customer? {
        return if (customerRepository.existsById(id)){
            customerRepository.save(newCustomer.copy(id = id))
        }else null
            
    }

    fun deleteCustomer(id: Long) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id)
        }
    }
}