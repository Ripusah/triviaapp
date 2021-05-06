package app.triviaapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import app.triviaapp.model.GameHistory;
import app.triviaapp.R;
import app.triviaapp.viewmodel.SummaryViewModel;
import app.triviaapp.helper.Helper;

public class SummaryActivity extends AppCompatActivity {
    private String answer1,answer2,answer3,date="";
    private TextView tvAnswer1,tvAnswer2,tvAnswer3;
    private Button btnFinish;
    private SummaryViewModel model;
    int count;
    private boolean insert=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.summary);
        btnFinish=findViewById(R.id.btn_next1);
        model= ViewModelProviders.of(this).get(SummaryViewModel.class);
        answer1=getIntent().getStringExtra("ANSWER1");
        answer2=getIntent().getStringExtra("ANSWER2");
        answer3=getIntent().getStringExtra("ANSWER3");
        tvAnswer1=findViewById(R.id.tv_answer1);
        tvAnswer2=findViewById(R.id.tv_answer2);
        tvAnswer3=findViewById(R.id.tv_answer3);
        tvAnswer1.setText(getString(R.string.hello,answer1));
        tvAnswer2.setText(answer2);
        tvAnswer3.setText(answer3);
        //this will get the total count of the game and update the count value
        model.getList().observe(this, new Observer<List<GameHistory>>() {
            @Override
            public void onChanged(List<GameHistory> gameHistories) {
                count=gameHistories.size()+1;
                Log.d("TAGCOunt", "onChanged: size "+count);
            }
        });

        //this is to start again the game from start, if the data is not save this will save the data first and start the game.
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue();
                finish();
                startActivity(new Intent(SummaryActivity.this,Question1Activity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //this will show the all the history of game with is stored in the databse, if the data of the current game is not saved it will save the data first
        // move to next page
        if (item.getItemId()==R.id.op_history){

            setValue();
            startActivity(new Intent(SummaryActivity.this,HistoryAtivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    //this method to save the data in database using viewmodel and roomdata base
    private void setValue() {
        if (insert) {
            GameHistory gameHistory = new GameHistory();
            //int count=model.getCount();
            gameHistory.setDate(Helper.getCurrentDate());
            gameHistory.setGame("Game " + count);
            gameHistory.setAnswer1(answer1);
            gameHistory.setAnswer2(answer2);
            gameHistory.setAnswer3(answer3);
            model.inssertGame(gameHistory);
            insert = false;
        }
    }
}