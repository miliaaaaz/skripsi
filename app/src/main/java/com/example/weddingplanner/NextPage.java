package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NextPage extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private EditText bridesName, groomsName;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        bridesName = findViewById(R.id.bridesName);
        groomsName = findViewById(R.id.groomsName);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        next = findViewById(R.id.next_btn);

        if (firebaseUser != null){
            next.setOnClickListener (next -> {
                if (bridesName.getText().length()>0 && groomsName.getText().length()>0){
                    saveData(bridesName.getText().toString(), groomsName.getText().toString());
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

    private void saveData(String bridesName, String groomsName){
        Map<String, Object> user = new HashMap<>();
        user.put("bridesName", bridesName);
        user.put("groomsName", groomsName);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                });

    }
}