package com.example.tuprak5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<Data> dataList;

    public SearchAdapter(ArrayList<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {

        Data data = dataList.get(position);

        holder.IV_Search.setImageResource(data.getFotoProfile());
        holder.tv_username.setText(data.getUsername());
        holder.tv_name.setText(data.getName());

        holder.IV_Search.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, PostActivity.class);
            intent.putExtra("data", data);
            holder.context.startActivity(intent);
        });

        holder.tv_username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, PostActivity.class);
            intent.putExtra("data", data);
            holder.context.startActivity(intent);
        });
        holder.tv_name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, PostActivity.class);
            intent.putExtra("data", data);
            holder.context.startActivity(intent);
        });

    }

    public void filterList(ArrayList<Data> filteredList) {
        dataList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView IV_Search;
        TextView tv_username, tv_name;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_Search = itemView.findViewById(R.id.iv_search);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_name = itemView.findViewById(R.id.tv_name);
            context = itemView.getContext();
        }
    }
}
