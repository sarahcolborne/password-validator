package com.example.a2_password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textField;
        final Button valButton;
        final TextView resultText;

        textField = (EditText) findViewById(R.id.enterPass);
        valButton = (Button) findViewById(R.id.valButton);
        resultText = (TextView) findViewById(R.id.resultText);

        //This code executes when the button is pressed
        valButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View x){
                String pass = textField.getText().toString(); //get password from textField when button is clicked
                Boolean validationResult = validate(pass);

                //if validationResult is true, the validate method approved the password
                if (validationResult){
                    resultText.setText("Strong enough!");
                    resultText.setTextColor(Color.parseColor("#11AF88"));
                }
                else {
                    resultText.setText("Not strong enough, try again");
                    resultText.setTextColor(Color.parseColor("#FF0055"));
                }
            }

        });

    }

    public static boolean validate(String pass){
        //if password is not at least 8 characters, fail
        if (pass.length() < 8){
            return false;
        }

        //if password is all lowercase, fail
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

        //if the password has passed all of these rules, it is strong enough
        return true;
    }

}
