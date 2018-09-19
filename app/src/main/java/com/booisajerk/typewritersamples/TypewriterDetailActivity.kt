package com.booisajerk.typewritersamples

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.content_typewriter.*

class TypewriterDetailActivity : BaseActivity() {
    private val TAG = "Parker" + TypewriterDetailActivity::class.qualifiedName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typewriter)
        Log.d(TAG, "onCreate")

        val id: Int = intent.getIntExtra(Constants.NAVIGATION_ID, 0)

        when (id) {
            R.id.nav_kolibri_groma -> {
                detail_title.setText(R.string.kolibri_groma)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.kolibri_groma_content)
            }
            R.id.nav_olivetti_lettera -> {
                detail_title.setText(R.string.olivetti_lettera)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.olivetti_lettera_content)
            }
            R.id.nav_royal_aristocrat -> {
                detail_title.setText(R.string.royal_aristocrat)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.royal_aristocrat_content)
            }
            R.id.nav_royal_aristocrat_two -> {
                detail_title.setText(R.string.royal_aristocrat_two)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.royal_aristocrat_two_content)
            }
            R.id.nav_royal_kmg -> {
                detail_title.setText(R.string.royal_kmg)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.royal_kmg_content)
            }
            R.id.nav_royal_quiet_de_luxe -> {
                detail_title.setText(R.string.royal_quiet_de_luxe)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.royal_quiet_de_luxe_content)
            }
            R.id.nav_underwood_universal -> {
                detail_title.setText(R.string.underwood_universal)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.underwood_universal_content)
            }
            R.id.nav_books -> {
                detail_title.setText(R.string.books_title)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.books_content)
            }
            R.id.nav_movies -> {
                detail_title.setText(R.string.movies_title)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.movies_content)
            }
            R.id.nav_websites -> {
                detail_title.setText(R.string.websites_title)
                // TODO add image detail_image.setImageResource(R.)
                detail_text.setText(R.string.websites_content)
            }
        }

        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")

        detail_title.typeface = typewriterFont
        detail_text.typeface = typewriterFont
        detail_image.setImageResource(R.mipmap.ic_typewriter)
    }
}
