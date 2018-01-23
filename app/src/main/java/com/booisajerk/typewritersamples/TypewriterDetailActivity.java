package com.booisajerk.typewritersamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TypewriterDetailActivity extends AppCompatActivity {

    //TODO display app bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typewriter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(TypewriterDetailActivity.this, MainActivity.class);
        intent.getExtras();

        //TODO get the intent from MainActivity

        TextView detailTitle = (TextView) findViewById(R.id.detail_title);
        TextView detailText = (TextView) findViewById(R.id.detail_text);
        ImageView detailImage = (ImageView) findViewById(R.id.detail_image);

        //TODO add case statement
    }
}
