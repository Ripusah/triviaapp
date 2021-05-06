package app.triviaapp.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import app.triviaapp.model.GameHistory;

@Dao
public interface GameHistoryDao {
    //this interface which will be called dao for performing operation of database
    @Insert
    long insertGame(GameHistory gameHistory);

    @Query("SELECT * FROM gamehistory")
    LiveData<List<GameHistory>> getAllHistory();

}
