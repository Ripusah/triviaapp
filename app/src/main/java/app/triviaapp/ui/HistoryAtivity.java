package app.triviaapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import app.triviaapp.model.GameHistory;
import app.triviaapp.R;
import app.triviaapp.viewmodel.SummaryViewModel;
import app.triviaapp.adapter.GameHistoryAdapter;

public class HistoryAtivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GameHistoryAdapter adapter;
    private SummaryViewModel model;
    private List<GameHistory> mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_ativity);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.game_hitory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        model= ViewModelProviders.of(this).get(SummaryViewModel.class);
        recyclerView=findViewById(R.id.recycleview);
        //this will fetch all the existing record to list in recycleview
        model.getList().observe(this, new Observer<List<GameHistory>>() {
            @Override
            public void onChanged(List<GameHistory> gameHistories) {
                mList.addAll(gameHistories);
                adapter.notifyDataSetChanged();
            }
        });
        setRecycleView();
    }

    //this will take into preivious page
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    //initialising the recycleview as well adapter
    private void setRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new GameHistoryAdapter(this,mList);
        recyclerView.setAdapter(adapter);
    }
}