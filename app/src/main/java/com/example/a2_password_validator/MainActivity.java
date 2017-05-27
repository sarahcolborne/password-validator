package com.example.a2_password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static boolean validate(String pass){
        if (pass.length() < 8){
            return false;
        }

        if (pass.toLowerCase().equals("password")){
            return false;
        }

        return true;
    }

}
