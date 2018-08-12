package com.booisajerk.typewritersamples

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val typewriterButtonFont = Typeface.createFromAsset(assets, "fonts/type_keys.ttf")
        splash_text.typeface = typewriterButtonFont

        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")
        splash_hint.typeface = typewriterFont
        //TODO add animation to this text

        splash_text.setOnClickListener {
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
