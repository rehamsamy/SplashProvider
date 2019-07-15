package com.openthedoorprovider;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.openthedoorprovider.adapter.NotificationAdaper;
import com.openthedoorprovider.pojo.DeleteNotificationResponse;
import com.openthedoorprovider.pojo.NotificationResponse;
import com.openthedoorprovider.pojo.ProvidernotficationItem;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.GridLayout.VERTICAL;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.pagination_recycler) RecyclerView recyclerView;
    NotificationAdaper adaper;
    RetrofitInterface retrofitInterface;
    List<ProvidernotficationItem> notificationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();
        int page=1;
        getNotification(page);
        swipRecycler();
    }

    private void getNotification( int page) {
        Map<String,Object> map=new HashMap<>();
        map.put("page",page);
        map.put("limit",1);
        map.put("provider_id",SignInActivity.loginResponse.getProviderinfo().getId());
        map.put("api_token",SignInActivity.loginResponse.getToken());
        Call<NotificationResponse>  call=retrofitInterface.getNotification(map);
        call.enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                notificationList = response.body().getProvidernotfication();
               LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                if (response.body().isStatus()) {
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    adaper = new NotificationAdaper(NotificationActivity.this, notificationList);
                    recyclerView.setAdapter(adaper);
                    DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
                    recyclerView.addItemDecoration(decoration);
                    recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
                        @Override
                        public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                           page = page;
                           page ++;

                        }
                    });
                }
            else {
                    Toast.makeText(NotificationActivity.this, "notification is empty", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable t) {
            }
        });
    }


    public  void swipRecycler(){
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

                deleteNotification(position);
            }
        }).attachToRecyclerView(recyclerView);

    }

    private void deleteNotification(int position) {
        Map<String,Object> map=new HashMap<>();
        map.put("not_id",notificationList.get(position).getId());
        map.put("api_token",SignInActivity.loginResponse.getToken());
        Call<DeleteNotificationResponse> call=retrofitInterface.deleteNotification(map);
        call.enqueue(new Callback<DeleteNotificationResponse>() {
            @Override
            public void onResponse(Call<DeleteNotificationResponse> call, Response<DeleteNotificationResponse> response) {
                Toast.makeText(NotificationActivity.this, response.body().getSuccessMsg(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<DeleteNotificationResponse> call, Throwable t) {
            }
        });
    }
}
