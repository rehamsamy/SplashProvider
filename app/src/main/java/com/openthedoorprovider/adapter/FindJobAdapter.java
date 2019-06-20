package com.openthedoorprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openthedoorprovider.R;

public class FindJobAdapter extends RecyclerView.Adapter<FindJobAdapter.Holder> {

    Context context;
    public FindJobAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public FindJobAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.find_job_list_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FindJobAdapter.Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder{
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
