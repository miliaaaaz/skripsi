package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

//    INI SEBENERNYA SIGN IN
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText useremail, userpass;
    private Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        useremail = findViewById(R.id.useremail);
        userpass = findViewById(R.id.userpass);
//        signin = findViewById(R.id.signin);

        signin.setOnClickListener(check->{
            if (useremail.getText().length()>0 && userpass.getText().length()>0){
                saveData(useremail.getText().toString(), userpass.getText().toString());
            }
            else{
                Toast.makeText(getApplicationContext(), "Input Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData(String email, String password) {
        Map<String, Object> user = new HashMap<>();

    }
}