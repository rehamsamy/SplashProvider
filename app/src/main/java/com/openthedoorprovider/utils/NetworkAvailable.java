package com.openthedoorprovider.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkAvailable {
    Context context;
    NetworkInfo networkInfo;
    ConnectivityManager manager;

    public NetworkAvailable(Context context){
        this.context=context;
    }

   public Boolean isAvailable(){

        manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo=manager.getActiveNetworkInfo();
        return networkInfo.isConnected() && networkInfo!=null;
   }

}
