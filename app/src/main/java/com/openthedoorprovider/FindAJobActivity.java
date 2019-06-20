package com.openthedoorprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.openthedoorprovider.adapter.FindJobAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindAJobActivity extends AppCompatActivity {

    @BindView(R.id.find_job_recycler) RecyclerView findJobRecycler;
    FindJobAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ajob);
        ButterKnife.bind(this);
        adapter=new FindJobAdapter(this);
        findJobRecycler.setLayoutManager(new LinearLayoutManager(this));
        findJobRecycler.setAdapter(adapter);

    }
}
