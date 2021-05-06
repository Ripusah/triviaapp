package app.triviaapp.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;
import app.triviaapp.model.GameHistory;
import app.triviaapp.interfaces.GameHistoryDao;
import app.triviaapp.database.GameHistoryDatabase;


public class MyRepository {

    private LiveData<List<GameHistory>> myList;

    private GameHistoryDatabase repository;
    private GameHistoryDao gameHistoryDao;
    private Application application;

    //this construct will initialise/create object of repository and Dao
    public MyRepository(Application application){
        this.application=application;
        repository= GameHistoryDatabase.getInstance(application);
        gameHistoryDao=repository.gameHistoryDao();
        myList=gameHistoryDao.getAllHistory();
    }

    // this method will take input from viewmodel and pass it to asynctask to insert the data in the database
    public void insertGame(GameHistory gameHistory)  {


        new InsertTransactionAsyncTask(application,gameHistoryDao).execute(gameHistory);

    }

    //this will return all the list present in the database
    public LiveData<List<GameHistory>> getList(){
        return myList;
    }

    // this asynctask will insert the data in background.
    class InsertTransactionAsyncTask extends AsyncTask<GameHistory,Void,Void> {

        GameHistoryDao gameHistoryDao;
        Application application;
        long id;

        public InsertTransactionAsyncTask(Application application, GameHistoryDao gameHistoryDao) {
            this.gameHistoryDao = gameHistoryDao;
            this.application=application;
        }

        @Override
        protected Void doInBackground(GameHistory... transactions) {
            id= gameHistoryDao.insertGame(transactions[0]);
            Log.d("MYTAG", "doInBackground: index "+id);
            Handler handler =  new Handler(application.getMainLooper());

            //this will check the success of the insertion of the data in the table.
            handler.post( new Runnable(){
                public void run() {
                    if (id != -1) {
                        Toast.makeText(application, "Transaction Inserted successfully ", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(application, "Error! ", Toast.LENGTH_LONG).show();
                    }
                }
            });
            return null;
        }


    }
}
