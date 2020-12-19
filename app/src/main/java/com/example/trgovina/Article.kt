package com.example.trgovina

import java.io.Serializable

data class Article(
        val article_id: Int = 0,
        val article_name: String = "",
        val article_price: Double = 0.0,
        val article_description: String = "",
        val article_status: Int = 0) : Serializable
