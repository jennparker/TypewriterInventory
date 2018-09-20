package com.booisajerk.typewritersamples

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.content_typewriter.*

class TypewriterDetailActivity : BaseActivity() {

    lateinit var machine: Machine

    companion object {
        val TAG = "Parker" + TypewriterDetailActivity::class.qualifiedName
        val NAVIGATION_ID = "navigationId"

        fun detailIntent(context: Context, position: Int): Intent {
            val intent = Intent(context, TypewriterDetailActivity::class.java)
            intent.putExtra(NAVIGATION_ID, position)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_typewriter)
        Log.d(TAG, "onCreate")

        loadMachine()
    }

    private fun loadMachine() {
        machine = MachineData.machineList()[intent.getIntExtra(NAVIGATION_ID, 0)]
        detail_image.setImageResource(machine.getImageResourceId(this))
        detail_title.setText(machine.name)
        setTypewriterFont(detail_title)
        setTypewriterFont(detail_text)
    }

    private fun setTypewriterFont(text:TextView) {
        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")
        text.typeface = typewriterFont
    }
}

