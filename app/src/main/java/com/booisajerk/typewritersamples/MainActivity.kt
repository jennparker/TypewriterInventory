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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        staggeredLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        list.layoutManager = staggeredLayoutManager

        adapter = MachineListAdapter(this)
        list.adapter = adapter
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.groupId) {
            R.id.search_group -> {
                val searchActivityIntent = Intent(this, SearchActivity::class.java)
                searchActivityIntent.putExtra(Constants.NAVIGATION_ID, item.itemId)
                startActivity(searchActivityIntent)
            }
            else -> {
                val typewriterDetailActivityIntent = Intent(this, TypewriterDetailActivity::class.java)
                typewriterDetailActivityIntent.putExtra(Constants.NAVIGATION_ID, item.itemId)
                startActivity(typewriterDetailActivityIntent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
