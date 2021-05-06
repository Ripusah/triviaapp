package app.triviaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.triviaapp.model.GameHistory;
import app.triviaapp.R;

public class GameHistoryAdapter extends RecyclerView.Adapter<GameHistoryViewHolder> {
    private Context mContext;
    private List<GameHistory> mList;

    public GameHistoryAdapter(Context mContext, List<GameHistory> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GameHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GameHistoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.content_history_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GameHistoryViewHolder holder, int position) {
        holder.tvAnswer1.setText(mContext.getResources().getString(R.string.name, mList.get(position).getAnswer1()));
        holder.tvAnswer2.setText(mList.get(position).getAnswer2());
        holder.tvAnswer3.setText(mList.get(position).getAnswer3());
        holder.tvDate.setText(mContext.getString(R.string.game,mList.get(position).getGame(),mList.get(position).getDate()));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
class GameHistoryViewHolder extends RecyclerView.ViewHolder{
    public TextView tvAnswer1,tvAnswer2,tvAnswer3,tvDate;
    public GameHistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        tvAnswer1=itemView.findViewById(R.id.tv_answer1);
        tvAnswer2=itemView.findViewById(R.id.tv_answer2);
        tvAnswer3=itemView.findViewById(R.id.tv_answer3);
        tvDate=itemView.findViewById(R.id.tv_game_no);
    }
}
