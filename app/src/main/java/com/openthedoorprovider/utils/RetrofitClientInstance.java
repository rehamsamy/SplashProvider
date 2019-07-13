package com.openthedoorprovider.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
   private static Retrofit retrofit=null;
   private static String base_url="https://openthedoor.app/";


    public static RetrofitInterface getRetrofitInstance(){
        if(retrofit==null){
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client=new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120,TimeUnit.SECONDS)
                    .readTimeout(120,TimeUnit.SECONDS)
                    .build();

            retrofit=new Retrofit.Builder()
                    .baseUrl(base_url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        RetrofitInterface retrofitInterface=retrofit.create(RetrofitInterface.class);

        return  retrofitInterface;
    }

}
