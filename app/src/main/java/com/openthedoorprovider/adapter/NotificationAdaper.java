package com.openthedoorprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openthedoorprovider.R;
import com.openthedoorprovider.pojo.ProvidernotficationItem;

import java.util.List;


public class NotificationAdaper extends RecyclerView.Adapter<NotificationAdaper.Holder> {

    Context context;
    List<ProvidernotficationItem> providernotficationItems;
    public NotificationAdaper(Context mContext, List<ProvidernotficationItem> mList) {
        context=mContext;
        providernotficationItems=mList;
    }

    @NonNull
    @Override
    public NotificationAdaper.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.notification_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdaper.Holder holder, int pos) {

      ProvidernotficationItem item=  providernotficationItems.get(pos);
        TextView notifyMesg=(TextView) holder.item.findViewById(R.id.notify_message_info);
        TextView time=(TextView) holder.item.findViewById(R.id.notify_time);

        notifyMesg.setText(item.getProviderNotfEn());
        time.setText(item.getCreatedAt());


    }

    @Override
    public int getItemCount() {
        return providernotficationItems.size();
    }

    public class Holder  extends RecyclerView.ViewHolder{

        View item;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item=itemView;
        }
    }
}
