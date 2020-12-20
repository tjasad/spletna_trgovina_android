package com.example.trgovina

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_article_detail.*
import kotlinx.android.synthetic.main.activity_user_preferencess.*

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

        nazajBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        shraniUsrBtn.setOnClickListener {
            val intent = Intent(this, EditUserFormActivity::class.java)
            startActivity(intent)
        }

    }
}

