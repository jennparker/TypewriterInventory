package com.booisajerk.typewritersamples

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit private var staggeredLayoutManager: StaggeredGridLayoutManager
    lateinit private var adapter: MachineListAdapter

    private val onItemClickListener = object : MachineListAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            startActivity(MachineDetailActivity.detailIntent(this@MainActivity, position))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        staggeredLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        list.layoutManager = staggeredLayoutManager

        adapter = MachineListAdapter(this)
        list.adapter = adapter
        adapter.setOnItemClickListener(onItemClickListener)
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val typewriterDetailActivityIntent = Intent(this, MachineDetailActivity::class.java)
        typewriterDetailActivityIntent.putExtra(Constants.NAVIGATION_ID, item.itemId)
        startActivity(typewriterDetailActivityIntent)

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
