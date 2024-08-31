package com.example.customer_management.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class CustomerDto(
    val id: Long? = null, // Optional for create, required for update

    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Invalid email format")
    val email: String,

    @field:NotBlank(message = "Phone number is required")
    @field:Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    val phoneNumber: String
)