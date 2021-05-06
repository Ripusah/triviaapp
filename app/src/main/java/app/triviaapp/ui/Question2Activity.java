package app.triviaapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import app.triviaapp.R;

public class Question2Activity extends AppCompatActivity {
    private RadioGroup rgOptions;
    private RadioButton radioButton;
    private TextView tvQuestion;
    private Button btnNext;
    private String  answer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.question_2);
        tvQuestion=findViewById(R.id.tv_question1);
        rgOptions =findViewById(R.id.rg_options);
        answer1=getIntent().getStringExtra("ANSWER1");

        btnNext=findViewById(R.id.btn_next1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling the method callintent
               callnextIntent();
            }
        });



    }
    //this method will take input from this page and make a call to next page called question3activity.
    //this will also validate the following radio button for input
    private void callnextIntent() {
        int selectedId = rgOptions.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (rgOptions.getCheckedRadioButtonId()==-1) {
            Toast.makeText(Question2Activity.this, "Kindly select any of them!", Toast.LENGTH_SHORT).show();

        }else{
            startActivity(new Intent(Question2Activity.this, Question3Activity.class)
                    .putExtra("ANSWER1", answer1)
                    .putExtra("ANSWER2", radioButton.getText()));
            finish();

        }
    }


}