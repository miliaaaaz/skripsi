package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignInPage extends AppCompatActivity {

//    INI SEBENERNYA SIGN IN
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText useremail, userpass;
    private Button signin;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        useremail = findViewById(R.id.useremail);
        userpass = findViewById(R.id.userpass);
        signin = findViewById(R.id.signin);
        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(check->{
            if (useremail.getText().length()>0 && userpass.getText().length()>0){
                loginCheck(useremail.getText().toString(), userpass.getText().toString());
            }
            else{
                Toast.makeText(getApplicationContext(), "Input Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginCheck(String useremail, String userpass){
        mAuth.signInWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult() != null){
                    if (task.getResult().getUser() != null){
                        reload();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void reload(){

        startActivity(new Intent(getApplicationContext(), NextPage.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }


}