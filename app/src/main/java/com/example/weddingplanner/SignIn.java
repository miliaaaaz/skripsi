package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

//INI PAGE SIGN UP SEBENERNYA

public class SignIn extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText useremail, userpass;
    private Button signup;
    private ProgressDialog progressDialog;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        useremail = findViewById(R.id.useremail);
        userpass = findViewById(R.id.userpass);
//        signup = findViewById(R.id.signup);
        progressDialog = new ProgressDialog(EditorActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Saving Data...");

        signup.setOnClickListener(save->{
            if (useremail.getText().length()>0 && userpass.getText().length()>0){
                saveData(useremail.getText().toString(), userpass.getText().toString());
            }
            else{
                Toast.makeText(getApplicationContext(), "Input Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData(String email, String password){
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("password", password);

        progressDialog.show();
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Saving Data Succeed", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
        }

    }
