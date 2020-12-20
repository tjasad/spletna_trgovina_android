package com.example.trgovina

import android.app.Application

class UserApplicationObject : Application() {
    var customer_id: String? = null
    var name: String? = null
    var surname: String? = null
    var street: String? = null
    var house_number: String? = null
    var post: String? = null
    var post_number: String? = null
    var email: String? = null
}