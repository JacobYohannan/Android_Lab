package com.example.ui_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t ;
    Button b;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll=new LinearLayout(this);
        t=new TextView(this);
        b= new Button(this);

        LinearLayout.LayoutParams dim=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dim);
        LinearLayout.LayoutParams vdim=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vdim.setMargins(0,50,0,0);
        t.setLayoutParams(vdim);
        b.setLayoutParams(vdim);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER);
            t.setText("Hello World");
            t.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t.setTextSize(35);

            b.setText("Button");
            b.setTextSize(30);
            b.setBackgroundColor(Color.CYAN);






        ll.addView(t);
        ll.addView(b);
        setContentView(ll);

    }
}