package app.triviaapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import app.triviaapp.R;

public class Question3Activity extends AppCompatActivity {
    private CheckBox cbWhite,cbYellow,cbOrange,cbGreen;
    private TextView tvQuestion;
    private Button btnNext;
    private String answer1,answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.question_3);

        answer1=getIntent().getStringExtra("ANSWER1");
        answer2=getIntent().getStringExtra("ANSWER2");
        tvQuestion=findViewById(R.id.tv_question2);
        cbWhite =findViewById(R.id.cb_white);
        cbYellow =findViewById(R.id.cb_yellow);
        cbOrange =findViewById(R.id.cb_orange);
        cbGreen =findViewById(R.id.cb_green);

        btnNext=findViewById(R.id.btn_next1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callnextIntent();
            }
        });
    }
    //this method will take input from this page and make a call to next page called question3activity.
    //this will also validate the following checkbot for input, it will select more than one option seperated by comma.
    private void callnextIntent() {
        String answer="";
        if (!cbWhite.isChecked() && !cbYellow.isChecked() && !cbOrange.isChecked() && !cbGreen.isChecked()){
            Toast.makeText(this, "Kindly select your answers!", Toast.LENGTH_SHORT).show();
        }else{
            if (cbWhite.isChecked()){
                answer+=getString(R.string.white);
            }
            if (cbYellow.isChecked()){
                if (TextUtils.isEmpty(answer)) {
                    answer += getString(R.string.yellow);
                }else{
                    answer +=","+ getString(R.string.yellow);
                }
            }
            if (cbOrange.isChecked()){
                if (TextUtils.isEmpty(answer)) {
                    answer += getString(R.string.orange);
                }else{
                    answer +=", "+ getString(R.string.orange);
                }
            }
            if (cbGreen.isChecked()){
                if (TextUtils.isEmpty(answer)) {
                    answer += getString(R.string.green);
                }else{
                    answer +=", "+ getString(R.string.green);
                }
            }
            startActivity(new Intent(Question3Activity.this, SummaryActivity.class)
                    .putExtra("ANSWER1", answer1)
                    .putExtra("ANSWER2", answer2)
                    .putExtra("ANSWER3", answer));
            finish();

        }
    }
}