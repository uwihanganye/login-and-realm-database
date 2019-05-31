package com.example.loginandrealmdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginandrealmdb.model.Register;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import io.realm.Realm;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    Button Register;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("activity register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText)findViewById(R.id.etUsername1);
        password = (EditText)findViewById(R.id.etPassword1);
        Register =(Button)findViewById(R.id.btnSave);
        realm= Realm.getDefaultInstance();

        Register.setOnClickListener(this);



    }
    @Override
    public void onClick(View view)
    {
        writeTodb(username.getText().toString().trim(), password.getText().toString().trim());
    }
    public void writeTodb(final String username, final String password){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Register userRegister = bgRealm.createObject(Register.class);
                userRegister.setUsername(username);
                userRegister.setPassword(password);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.v("Database", "Data inserted");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.e("Database", error.getMessage());
            }
        });

    }

    protected void onDstroy(){
        super.onDestroy();
        realm.close();
    }
}
