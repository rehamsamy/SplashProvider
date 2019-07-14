package com.openthedoorprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.openthedoorprovider.adapter.FindJobAdapter;
import com.openthedoorprovider.pojo.ServicesItem;

import java.util.List;
import java.util.ServiceConfigurationError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindAJobActivity extends AppCompatActivity {

    @BindView(R.id.find_job_recycler) RecyclerView findJobRecycler;
    FindJobAdapter adapter;
    List<ServicesItem> servicesItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ajob);
        ButterKnife.bind(this);
       servicesItemList= HomeActivity.servicesList;
        adapter=new FindJobAdapter(this,servicesItemList);
        findJobRecycler.setLayoutManager(new LinearLayoutManager(this));
        findJobRecycler.setAdapter(adapter);

    }
}
