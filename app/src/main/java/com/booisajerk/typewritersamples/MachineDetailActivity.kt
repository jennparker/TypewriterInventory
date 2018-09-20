package com.booisajerk.typewritersamples

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.content_machine_detail.*

class MachineDetailActivity : BaseActivity() {

    lateinit var machine: Machine

    companion object {
        val TAG = "Parker" + MachineDetailActivity::class.qualifiedName
        val NAVIGATION_ID = "navigationId"

        fun detailIntent(context: Context, position: Int): Intent {
            val intent = Intent(context, MachineDetailActivity::class.java)
            intent.putExtra(NAVIGATION_ID, position)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_detail)
        Log.d(TAG, "onCreate")

        loadMachine()
    }

    private fun loadMachine() {
        machine = MachineData.machineList()[intent.getIntExtra(NAVIGATION_ID, 0)]
        detailImage.setImageResource(machine.getImageResourceId(this))
        detailTitle.setText(machine.name)
        setTypewriterFont(detailTitle)
        setTypewriterFont(detailText)
    }

    private fun setTypewriterFont(text:TextView) {
        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")
        text.typeface = typewriterFont
    }
}

