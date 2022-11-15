package com.example.simplecalc;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.simplecalc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display_1;
    TextView display_2;

    Double leftValue;
    Double rightValue;
    Double resultValue;
    String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display_1 = findViewById(R.id.text_dis1);
        display_2 = findViewById(R.id.text_dis2);
        leftValue=0.0;
        rightValue=0.0;
        resultValue=0.0;
    }
    public void doCalculation(View view){
        rightValue = Double.parseDouble(display_2.getText().toString());
        switch(operator){
            case  "+":
                resultValue = leftValue + rightValue;
                break;
            case  "-":
                resultValue = leftValue - rightValue;
                break;
            case  "x":
                resultValue = leftValue * rightValue;
                break;
            case  "/":;
                resultValue = leftValue / rightValue;
                break;
            default:
                Toast.makeText(this, "Invalid option",Toast.LENGTH_SHORT).show();
        }
        display_2.setText(resultValue.toString());
        display_1.setText(display_1.getText().toString()+rightValue+" =");
}}