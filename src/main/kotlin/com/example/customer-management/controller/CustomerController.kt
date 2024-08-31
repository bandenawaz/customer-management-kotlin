package com.example.customer_management.controller

import com.example.customer_management.dto.CustomerDto
import com.example.customer_management.model.Customer
import com.example.customer_management.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = ["http://localhost:5173"]) // Enable CORS for this controller
class CustomerController(@Autowired val customerService: CustomerService){

    @GetMapping
    fun getAllCustomers() = customerService.getAllCustomers()

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long) = customerService.getCustomerById(id)

    @PostMapping
    fun createCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<Any> {
        return try {
            val customer = Customer(
                name = customerDto.name,
                email = customerDto.email,
                phoneNumber = customerDto.phoneNumber
            )
            ResponseEntity(customerService.createCustomer(customer), HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: ${e.message}")
        }
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customerDto: CustomerDto): ResponseEntity<Any> {
        return try {
            val customer = Customer(
                id = id,
                name = customerDto.name,
                email = customerDto.email,
                phoneNumber = customerDto.phoneNumber
            )
            ResponseEntity.ok(customerService.updateCustomer(id, customer))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: ${e.message}")
        }
    }
    @GetMapping("/delete/{id}")
    fun deleteCustomer(@PathVariable id: Long) = customerService.deleteCustomer(id)
}