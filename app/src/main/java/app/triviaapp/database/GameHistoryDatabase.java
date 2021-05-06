package app.triviaapp.database;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

import app.triviaapp.model.GameHistory;
import app.triviaapp.interfaces.GameHistoryDao;

@Database(entities = GameHistory.class, version = 1)
public abstract class GameHistoryDatabase extends RoomDatabase {
    //this is the database which will store the data and fetch the data based on the request.
    public abstract GameHistoryDao gameHistoryDao();


    public static volatile GameHistoryDatabase repository;


    private final MutableLiveData<List<GameHistory>> myList = new MutableLiveData<>();

    public static GameHistoryDatabase getInstance(Context context) {
        if (repository == null) {
            synchronized (GameHistoryDatabase.class) {
                if (repository == null) {
                    repository = Room.databaseBuilder(context.getApplicationContext(), GameHistoryDatabase.class, "gamehistory_database").build();
                }
            }
        }
        return repository;
    }
}

