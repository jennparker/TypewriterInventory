package com.booisajerk.typewritersamples

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.content_typewriter.*

class TypewriterDetailActivity : AppCompatActivity() {

    //TODO display app bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typewriter)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val intent = Intent(this@TypewriterDetailActivity, MainActivity::class.java)
        intent.extras

        //TODO get the intent from MainActivity
        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")

        detail_title.typeface = typewriterFont
        detail_text.typeface = typewriterFont
        detail_image.setImageResource(R.mipmap.ic_typewriter)


        //TODO add case statement
    }
}
