package com.example.implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b0, b1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);



        b0.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:10.0603, 76.6352"));
            Intent Chooser=intent.createChooser(intent,"launchMap");
            startActivity(Chooser);
        });

        b1.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            String to[]={"jacobyohannan191@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "aNdRoId LaB");
            Intent Chooser=intent.createChooser(intent,"launch Mail");
            startActivity(Chooser);
        });


    }
    }