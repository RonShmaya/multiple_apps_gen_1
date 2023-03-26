package com.ron.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.ron.common.utils.UserScore;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private ArrayList<UserScore> users;

    public TopAdapter( ArrayList<UserScore> users) {
        this.users = users;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_top, parent, false);
        TopHolder topHolder = new TopHolder(view);
        return topHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final TopHolder holder = (TopHolder) viewHolder;
        UserScore userScore = getItem(position);

        holder.top_LBL.setText("Name: "+userScore.getName()+", Score: "+userScore.getScore());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public UserScore getItem(int position) {
        return users.get(position);
    }


    class TopHolder extends RecyclerView.ViewHolder {

        private MaterialTextView top_LBL;

        public TopHolder(View itemView) {
            super(itemView);
            top_LBL = itemView.findViewById(R.id.top_LBL);
        }

    }
}