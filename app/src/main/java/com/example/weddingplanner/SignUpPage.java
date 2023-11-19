package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

//INI PAGE SIGN UP SEBENERNYA

public class SignUpPage extends AppCompatActivity {
    //INI TEST ASYEL BLABLABLALA



    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText useremail, userpass;
    private Button signup;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        useremail = findViewById(R.id.useremail);
        userpass = findViewById(R.id.userpass);
        signup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
//        signin = findViewById(R.id.signin);
//        progressDialog = new ProgressDialog(EditorActivity.this);
//        progressDialog.setTitle("Loading");
//        progressDialog.setMessage("Saving Data...");

//        signin.setOnClickListener(save->{
//            finish();
//        })

        signup.setOnClickListener(save->{
            if (useremail.getText().length()>0 && userpass.getText().length()>0){
                saveData(useremail.getText().toString(), userpass.getText().toString());
            }
            else{
                Toast.makeText(getApplicationContext(), "Input Email and Password", Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(save->{
            startActivity(new Intent(getApplicationContext(), SignInPage.class));
        });
    }


    private void saveData(String useremail, String userpass){
        mAuth.createUserWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult() != null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    }
                    else{
                        Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


        private void reload(){
        startActivity(new Intent(getApplicationContext(), SignInPage.class));
        }

        @Override
        public void onStart() {
            super.onStart();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null){
                reload();
            }
        }

    }
