package com.example.tuprak5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuprak5.Data;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CardViewHolder> {
    private final List<Data> postList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Data post);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public PostAdapter(List<Data> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Data post = postList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView ivProfile, ivPostingan, ivDelete;
        private final TextView tvUsername, tvName, tvDesc;
        private final RelativeLayout postHeadView;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.IV_Profile);
            ivPostingan = itemView.findViewById(R.id.IV_Postingan);
            ivDelete = itemView.findViewById(R.id.IV_Delete);
            tvUsername = itemView.findViewById(R.id.TV_username);
            tvName = itemView.findViewById(R.id.TV_name);
            tvDesc = itemView.findViewById(R.id.TV_Desc);
            postHeadView = itemView.findViewById(R.id.postHead);

            // Set up onClickListener for the item
            postHeadView.setOnClickListener(this);
            ivDelete.setOnClickListener(this);
        }

        void bind(Data post) {
            ivProfile.setImageResource(post.getFotoProfile());
            ivPostingan.setImageResource(post.getFotoPostingan());
            tvUsername.setText(post.getUsername());
            tvName.setText(post.getName());
            tvDesc.setText(post.getDeskripsi());
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Data post = postList.get(position);
                    if (v.getId() == R.id.IV_Delete) {
                        postList.remove(position);
                        notifyItemRemoved(position);
                    } else {
                        onItemClickListener.onItemClick(post);
                    }
                }
            }
        }
    }
}
