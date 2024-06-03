package com.example.tuprak5;

//package com.example.tuprak3;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PostActivity extends AppCompatActivity {

    private ImageView ivProfile;
    private ImageView ivFeed;
    private TextView tvName, tvCaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();

        // Retrieve the Data object from the intent
        Data data = intent.getParcelableExtra("data");

        // Find views by their IDs
        ivProfile = findViewById(R.id.iv_profile);
        ivFeed = findViewById(R.id.iv_post);
        tvName = findViewById(R.id.tv_user);
        tvCaption = findViewById(R.id.tv_desc);

        // Set the views based on the Data object
        ivProfile.setImageResource(data.getFotoProfile());
        ivFeed.setImageResource(data.getFotoPostingan());
        tvName.setText(data.getUsername());
        tvCaption.setText(data.getDeskripsi());


    }
}