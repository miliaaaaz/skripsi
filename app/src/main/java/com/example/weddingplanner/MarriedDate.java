package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MarriedDate extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private EditText marriedDate;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Button next;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_married_date);

        marriedDate = findViewById(R.id.marriedDate);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        next = findViewById(R.id.submitmarriedDate);

        progressDialog = new ProgressDialog(MarriedDate.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Saving Data...");

        if (firebaseUser != null){
            next.setOnClickListener (next -> {
                if (marriedDate.getText().length()>0){
                    saveData(marriedDate.getText().toString());
                }
                else {
                    Toast.makeText(getApplicationContext(), "Field tidak boleh kosong.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(), "Harap melakukan Login untuk melanjutkan aktivitas", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData(String marriedDate){
        Map<String, Object> user = new HashMap<>();
        user.put("marriedDate", marriedDate);

        progressDialog.show();
        db.collection("users").document(id)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        progressDialog.dismiss();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });

    }
}