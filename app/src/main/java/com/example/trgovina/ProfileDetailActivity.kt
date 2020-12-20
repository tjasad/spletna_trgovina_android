package com.example.trgovina

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_article_detail.*
import kotlinx.android.synthetic.main.activity_user_preferencess.*
import kotlinx.android.synthetic.main.content_article_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class ProfileDetailActivity : AppCompatActivity() {
    private var article: Article = Article()

    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = this::class.java.canonicalName

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_preferencess)
        setSupportActionBar(toolbar)

        val app = application as UserApplicationObject;

        nameText.text = app.name
        surnameText.text = app.surname
        emailText1.text = app.email
        houseNumberText.text = app.house_number
        postText.text = app.post
        postNumberText.text = app.post_number
        streetText.text = app.street

    }
}

