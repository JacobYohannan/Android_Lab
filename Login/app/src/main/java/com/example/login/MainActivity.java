package com.example.login;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText ed1,ed2;
    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.username);
        ed2 = (EditText)findViewById(R.id.password);
        B1=(Button)findViewById(R.id.login);
        B1.setOnClickListener(this);
    }
    public void onClick(View v) {

                if (ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(this, "Login Success",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Incorrect Username or Password",
                            Toast.LENGTH_SHORT).show();
                }
            }

    }
