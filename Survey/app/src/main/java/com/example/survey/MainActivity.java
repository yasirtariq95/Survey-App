package com.example.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private Button btnUpload;
    private Button btnShowQuestions;
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = findViewById(R.id.etInput);
        btnUpload = findViewById(R.id.btnSubmit);
        btnShowQuestions = findViewById(R.id.btnShowQuestions);

        myRef = FirebaseDatabase.getInstance().getReference("names");

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = myRef.push().getKey();
                Question qt = new Question(id, "What?");
                myRef.child(id).setValue(qt);
            }
        });

        btnShowQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), QuestionActivity.class);
                startActivity(it);

            }
        });
    }
}
