package com.example.trgovina

import java.io.Serializable

data class User(
        val customer_id: String = "",
        val name: String = "",
        val surname: String = "",
        val street: String = "",
        val house_number: String = "",
        val post: String = "",
        val post_number: String = "",
        val email: String = "",
        val password: String = "",
        val role: String = "",
        val status: String = "") : Serializable
