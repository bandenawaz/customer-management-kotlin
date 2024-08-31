package com.example.customer_management.repoistory

import com.example.customer_management.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}