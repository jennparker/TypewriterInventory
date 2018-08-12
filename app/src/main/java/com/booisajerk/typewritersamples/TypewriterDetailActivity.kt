package com.booisajerk.typewritersamples

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import kotlinx.android.synthetic.main.content_typewriter.*

class TypewriterDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typewriter)

        val intent = Intent(this@TypewriterDetailActivity, MainActivity::class.java)
        intent.extras

        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")

        detail_title.typeface = typewriterFont
        detail_text.typeface = typewriterFont
        detail_image.setImageResource(R.mipmap.ic_typewriter)
    }
}
