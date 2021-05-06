package app.triviaapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "gamehistory")
public class GameHistory {
    // this is class
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    @NonNull
    @ColumnInfo(name="date")
    private String date;

    @NonNull
    @ColumnInfo(name="game")
    private String game;

    @NonNull
    @ColumnInfo(name="answer1")
    private String answer1;

    @NonNull
    @ColumnInfo(name="answer2")
    private String answer2;

    @NonNull
    @ColumnInfo(name="answer3")
    private String answer3;

    public GameHistory(){}


    public GameHistory(int id, @NonNull String date, @NonNull String game, @NonNull String answer1, @NonNull String answer2, @NonNull String answer3) {
        this.id = id;
        this.date = date;
        this.game = game;

        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getGame() {
        return game;
    }

    public void setGame(@NonNull String game) {
        this.game = game;
    }


    @NonNull
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(@NonNull String answer1) {
        this.answer1 = answer1;
    }

    @NonNull
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(@NonNull String answer2) {
        this.answer2 = answer2;
    }

    @NonNull
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(@NonNull String answer3) {
        this.answer3 = answer3;
    }
}
