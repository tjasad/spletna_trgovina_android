package com.example.trgovina

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_article_detail.*
import kotlinx.android.synthetic.main.content_article_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class ArticleDetailActivity : AppCompatActivity() {
    private var article: Article = Article()

    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = this::class.java.canonicalName

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra("artikel.id", 0)

        if (id > 0) {
            ArticleService.instance.get(id).enqueue(OnLoadCallbacks(this))
        }
    }


    private class OnLoadCallbacks(val activity: ArticleDetailActivity) : Callback<Article> {
        private val tag = this::class.java.canonicalName

        override fun onResponse(call: Call<Article>, response: Response<Article>) {
            activity.article = response.body() ?: Article()

            Log.i(tag, "Got result: ${activity.article}")

            if (response.isSuccessful) {
                activity.tvArticleDetail.text = activity.article.article_price.toString() + "EUR" +"\n"+ activity.article.article_description
                activity.toolbarLayout.title = activity.article.article_name
            } else {
                val errorMessage = try {
                    "An error occurred: ${response.errorBody()?.string()}"
                } catch (e: IOException) {
                    "An error occurred: error while decoding the error message."
                }

                Log.e(tag, errorMessage)
                activity.tvArticleDetail.text = errorMessage
            }
        }

        override fun onFailure(call: Call<Article>, t: Throwable) {
            Log.w(tag, "Error: ${t.message}", t)
        }
    }
}

