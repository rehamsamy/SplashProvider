package com.openthedoorprovider.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.openthedoorprovider.EndServiceActivity;
import com.openthedoorprovider.R;
import com.openthedoorprovider.ReportProblemActivity;

public class InprocessTabAdapter extends RecyclerView.Adapter<InprocessTabAdapter.Holder> {

    Context context;
    public InprocessTabAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public InprocessTabAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.inprocess_list_item,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InprocessTabAdapter.Holder holder, final int i) {

      MaterialButton  endservice=(MaterialButton) holder.itemView.findViewById(R.id.end_service);

      endservice.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              context.startActivity(new Intent(context, EndServiceActivity.class));
          }
      });

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              showPopup(i);

          }
      });

    }

    private void showPopup(int i) {
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.activity_in_process_popup);
        dialog.setCancelable(true);
       ImageView reportProblem= (ImageView)dialog.findViewById(R.id.report_proplem_icon);

       reportProblem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               context.startActivity(new Intent(context, ReportProblemActivity.class));
           }
       });

       ImageView cancelService= (ImageView) dialog.findViewById(R.id.cancel_service_icon);
       cancelService.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });

       dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        FrameLayout layout=(FrameLayout) dialog.findViewById(R.id.frame_root);

        layout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();

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


