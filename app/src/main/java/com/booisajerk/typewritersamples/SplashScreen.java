package com.booisajerk.typewritersamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        TextView splashText = findViewById(R.id.splash_text);
        TextView splashHint = findViewById(R.id.splash_hint);

        Typeface typewriterButtonFont = Typeface.createFromAsset(getAssets(), "fonts/type_keys.ttf");
        splashText.setTypeface(typewriterButtonFont);

        Typeface typewriterFont = Typeface.createFromAsset(getAssets(), "fonts/lc_smith_5_typewriter.ttf");
        splashHint.setTypeface(typewriterFont);
        //TODO add ic_typewriter_black animation to this text

        splashText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
