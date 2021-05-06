package app.triviaapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import app.triviaapp.model.GameHistory;
import app.triviaapp.repository.MyRepository;

public class SummaryViewModel extends AndroidViewModel {
    private MyRepository repositry;
    private final LiveData<List<GameHistory>> myList ;

    public SummaryViewModel(@NonNull Application application) {
        super(application);
        repositry= new MyRepository(application);
        myList=repositry.getList();

    }

    //this will insert the value in the datebase
    public void inssertGame(GameHistory gameHistory){
        repositry.insertGame(gameHistory);
    }


    //this will get all the list of existing game history present in the database
    public LiveData<List<GameHistory>> getList(){
        return myList;
    }



}
