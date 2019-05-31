package com.example.loginandrealmdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnLogin);
        Button button2 = findViewById(R.id.btnRegister);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRegister:
                Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.btnLogin:
                Intent intenty= new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intenty);
                break;

        }

    }
}