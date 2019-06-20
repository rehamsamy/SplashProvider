package com.openthedoorprovider.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.openthedoorprovider.R;

public class CompletedTabAdapter extends RecyclerView.Adapter<CompletedTabAdapter.Holder> {

        Context context;
public CompletedTabAdapter(Context context) {
        this.context=context;
        }

@NonNull
@Override
public CompletedTabAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.completed_list_item,viewGroup,false);

        return new Holder(view);
        }

@Override
public void onBindViewHolder(@NonNull CompletedTabAdapter.Holder holder, final int i) {

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopup(i);
        }

        private void showPopup(int i) {
            Dialog dialog=new Dialog(context);

            dialog.setCancelable(true);
            dialog.setContentView(R.layout.activity_completed_popup);


        // ConstraintLayout layout=   (ConstraintLayout) dialog.findViewById(R.id.cons_root);
           FrameLayout frameLayout=(FrameLayout) dialog.findViewById(R.id.frame_root);

         dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
         dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
         //layout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
           frameLayout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


           dialog.show();

        }
    });


        }

@Override
public int getItemCount() {
        return 2;
        }

public class Holder extends RecyclerView.ViewHolder {
    public Holder(@NonNull View itemView) {
        super(itemView);
    }
}
}




//how-to-create-a-barchart-with-grouped-bars-with-mpandroidchart