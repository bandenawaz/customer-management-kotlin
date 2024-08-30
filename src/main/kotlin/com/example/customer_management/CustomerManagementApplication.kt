package com.example.customer_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerManagementApplication

fun main(args: Array<String>) {
	runApplication<CustomerManagementApplication>(*args)
}
