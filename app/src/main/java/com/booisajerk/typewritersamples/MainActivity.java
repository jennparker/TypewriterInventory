package com.booisajerk.typewritersamples;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

//TODO get images for all typewriters

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView welcomeText = (TextView) findViewById(R.id.main_content_text);

        Typeface typewriterFont = Typeface.createFromAsset(getAssets(), "fonts/lc_smith_5_typewriter.ttf");
        welcomeText.setTypeface(typewriterFont);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_credits) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        String navigationId = "navigationId";
      //  int itemId = 0;

        // Handle navigation view item clicks here.
        int id = item.getItemId();
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
        Intent typewriterDetailActivityIntent = new Intent(MainActivity.this, TypewriterDetailActivity.class);
        typewriterDetailActivityIntent.putExtra(navigationId, id);
        startActivity(typewriterDetailActivityIntent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
