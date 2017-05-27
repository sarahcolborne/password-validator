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

        //My Custom 3 Rules:

        //Password must contain a number
        //note, I got help for this from stackoverflow: https://stackoverflow.com/questions/18590901/check-if-a-string-contains-numbers-java
        if (!(pass.matches(".*[0-9]+.*"))){
            return false;
        }

        //Password must contain a ! or $
        if (!(pass.contains("!")) && (!(pass.contains("$")))){
            return false;
        }

        //Password must contain an uppercase letter
        if (pass.equals(pass.toLowerCase())){
            return false;
        }

        return true;
    }

}
