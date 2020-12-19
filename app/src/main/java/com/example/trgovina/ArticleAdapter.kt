package com.example.trgovina

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*

class ArticleAdapter(context: Context) : ArrayAdapter<Article>(context, 0, ArrayList()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Check if an existing view is being reused, otherwise inflate the view
        val view = if (convertView == null)
            LayoutInflater.from(context).inflate(R.layout.articlelist_element, parent, false)
        else
            convertView

        val tvArticleName = view.findViewById<TextView>(R.id.tvArticleName)
        val tvArticleDescription = view.findViewById<TextView>(R.id.tvArticleDescription)
        val tvPrice = view.findViewById<TextView>(R.id.tvPrice)


        val article = getItem(position)

        tvArticleName.text = article?.article_name
        tvArticleDescription.text = article?.article_description
        tvPrice.text = String.format(Locale.ENGLISH, "%.2f EUR", article?.article_price)

        return view
    }
}
