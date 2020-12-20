package com.example.trgovina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_edit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class EditUserFormActivity : AppCompatActivity(), Callback<Void> {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit)
        val app = application as UserApplicationObject;


        shraniUsrBtn.setOnClickListener {

            val id = app.costumer_id
            val name = sendName.text.toString().trim()
            val surname = sendSurname.text.toString().trim()
            val street = sendStreet.text.toString().trim()
            val houseNumber = sendHouseNumber.text.toString().trim()
            val post = sendPost.text.toString().trim()
            val postNumber = sendPostNumber.text.toString().trim()
            val email = sendEmail.text.toString().trim()

            if (id != null) {
                UserService.instance.update(id,name,surname,street,houseNumber,post, postNumber,email).enqueue(this)
                app.name = sendName.text.toString().trim()
                app.surname = sendSurname.text.toString().trim()
                app.street = sendStreet.text.toString().trim()
                app.house_number = sendHouseNumber.text.toString().trim()
                app.post = sendPost.text.toString().trim()
                app.post_number = sendPostNumber.text.toString().trim()
                app.email = sendEmail.text.toString().trim()

            }
        }

        nazajBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        sendName.setText(app.name);
        sendSurname.setText(app.surname);
        sendEmail.setText(app.email);
        sendStreet.setText(app.street);
        sendHouseNumber.setText(app.house_number);
        sendPost.setText(app.post);
        sendPostNumber.setText(app.post_number);

    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        val headers = response.headers()

        if (response.isSuccessful) {
            //hočmo se sprement sejo

            val intent = Intent(this, ProfileDetailActivity::class.java)
            startActivity(intent)
        } else {
            val errorMessage = try {
                "An error occurred: ${response.errorBody()?.string()}"
            } catch (e: IOException) {
                "An error occurred: error while decoding the error message."
            }

        }
    }

    override fun onFailure(call: Call<Void>, t: Throwable) {
        Log.w("Error: ${t.message}", t)
    }


}
