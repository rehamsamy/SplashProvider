package com.openthedoorprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.openthedoorprovider.adapter.ReviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewsActivity extends AppCompatActivity {

    @BindView(R.id.review_recycler)RecyclerView reviewRecycler;
    ReviewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        ButterKnife.bind(this);
        adapter=new ReviewAdapter(this);
        reviewRecycler.setLayoutManager(new LinearLayoutManager(this));

        reviewRecycler.setAdapter(adapter);







    }
}
