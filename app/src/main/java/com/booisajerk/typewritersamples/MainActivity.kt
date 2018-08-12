package com.booisajerk.typewritersamples

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

//TODO get images for all typewriters

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typewriterFont = Typeface.createFromAsset(assets, "fonts/lc_smith_5_typewriter.ttf")

        main_content_text.typeface = typewriterFont

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
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

        val navigationId = "navigationId"
        //  int itemId = 0;

        // Handle navigation view item clicks here.
        val id = item.itemId
        //
        //        if (id == R.id.nav_kolibri_groma) {
        //            itemId = R.id.nav_kolibri_groma;
        //        } else if (id == R.id.nav_royal_aristocrat) {
        //            itemId = R.id.nav_royal_aristocrat;
        //        } else if (id == R.id.nav_underwood_universal) {
        //            itemId = R.id.nav_underwood_universal;
        //        } else if (id == R.id.nav_books) {
        //            itemId = R.id.nav_books;
        //        } else if (id == R.id.nav_movies) {
        //            itemId = R.id.nav_movies;
        //        } else if (id == R.id.nav_websites) {
        //            itemId = R.id.nav_websites;
        //        }

        //Add the id to an intent to pass to TypewriterDetailActivity
        val typewriterDetailActivityIntent = Intent(this@MainActivity, TypewriterDetailActivity::class.java)
        typewriterDetailActivityIntent.putExtra(navigationId, id)
        startActivity(typewriterDetailActivityIntent)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
