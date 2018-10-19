package com.example.user.footballclub

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    lateinit var nameTextView: TextView
    lateinit var detailTextView: TextView
    lateinit var imageImage: ImageView

    private lateinit var club: Item



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)
            imageImage = imageView().lparams(dip(92), dip(92)){
                gravity = Gravity.CENTER
            }
            nameTextView = textView{
                gravity = Gravity.CENTER
                typeface = Typeface.DEFAULT_BOLD
            }
            detailTextView = textView{
                leftPadding = dip(2)
                rightPadding = dip(2)

            }
        }

        val intent = intent
        club = intent.getParcelableExtra("club")
        Glide.with(this).load(club.image).into(imageImage)
        detailTextView.text = club.detail
        nameTextView.text = club.name

    }
}
