package com.openthedoorprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openthedoorprovider.R;
import com.openthedoorprovider.pojo.ServicesItem;

import java.util.List;

public class FindJobAdapter extends RecyclerView.Adapter<FindJobAdapter.Holder> {

    Context context;
    List<ServicesItem> servicesItemList;
    public FindJobAdapter(Context context,List<ServicesItem> mlist) {

        this.context=context;
        servicesItemList=mlist;
    }

    @NonNull
    @Override
    public FindJobAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.find_job_list_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FindJobAdapter.Holder holder, int pos) {
        ServicesItem item=servicesItemList.get(pos);
      TextView serviceType=  (TextView)holder.item.findViewById(R.id.service_type);
      serviceType.setText(item.getServiceNameEn());

    }

    @Override
    public int getItemCount() {
        return servicesItemList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        View item;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item=itemView;
        }
    }
}
