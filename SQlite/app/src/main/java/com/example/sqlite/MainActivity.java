package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button b0, b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.insert);
        b1 = findViewById(R.id.view);
        b0.setOnClickListener(view -> {
            Intent myIntent1 = new Intent(MainActivity.this, MainActivity2.class);
            MainActivity.this.startActivity(myIntent1);
        });
        b1.setOnClickListener(view -> {
            Intent myIntent2 = new Intent(MainActivity.this, MainActivity3.class);
            MainActivity.this.startActivity(myIntent2);
        });



    }
}
