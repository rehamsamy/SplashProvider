package com.openthedoorprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openthedoorprovider.R;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.Holder> {


    Context context;
    public ReviewAdapter( Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public ReviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.review_list_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Holder  extends RecyclerView.ViewHolder{
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
