package app.triviaapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import app.triviaapp.R;

public class Question1Activity extends AppCompatActivity {
    private EditText etAnswer;
    private TextView tvQuestion;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.question_1);
        tvQuestion=findViewById(R.id.tv_question);
        etAnswer=findViewById(R.id.et_answer1);
        btnNext=findViewById(R.id.btn_next1);

        //this button click listner will take input from this page and start the next page also pass the value from this page.
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etAnswer.getText().toString())) {
                    startActivity(new Intent(Question1Activity.this, Question2Activity.class)
                            .putExtra("ANSWER1", etAnswer.getText().toString()));
                    finish();
                }else{
                    Toast.makeText(Question1Activity.this, "Kindly answer this question!", Toast.LENGTH_SHORT).show();
                    etAnswer.requestFocus();
                }
            }
        });



    }
}