package com.example.frame_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (ImageView) findViewById(R.id.image1);
        r2 = (ImageView) findViewById(R.id.image2);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
    }0
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.image1) {
                r1.setVisibility(View.GONE);
                r2.setVisibility(View.VISIBLE);
            }
            else {
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.GONE);
            }
        }

    }
