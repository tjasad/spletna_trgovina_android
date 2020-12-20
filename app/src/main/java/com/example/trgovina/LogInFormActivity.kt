package com.example.trgovina

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_log_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class LogInFormActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        logInBtn.setOnClickListener {
            val email = emailText.text.toString().trim()
            val password = passwordText.text.toString().trim()

            UserService.instance.logIn(email,password).enqueue(LogInFormActivity.OnLoadCallbacks(this))

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        //val book = intent?.getSerializableExtra("ep.rest.book") as User?

    }

    private class OnLoadCallbacks(val activity: LogInFormActivity) : Callback<User> {
        private val tag = this::class.java.canonicalName

        override fun onResponse(call: Call<User>, response: Response<User>) {
            activity.user = response.body() ?: User()

            Log.i(tag, "Got result: ${activity.user}")

            if (response.isSuccessful) {
                //tle je pa treba shranit v nekaj podobnega seji
                //in it nazaj na trgovina activity

            } else {
                val errorMessage = try {
                    "An error occurred: ${response.errorBody()?.string()}"
                } catch (e: IOException) {
                    "An error occurred: error while decoding the error message."
                }

                Log.e(tag, errorMessage)
            }
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            Log.w(tag, "Error: ${t.message}", t)
        }
    }


}
