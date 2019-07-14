package com.openthedoorprovider;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoorprovider.pojo.ServiceResponse;
import com.openthedoorprovider.pojo.ServicesItem;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {

   @BindView(R.id.home_toolbar) Toolbar toolbar;
    @BindView(R.id.map_view) MapView mapView;
    @BindView(R.id.nv) NavigationView navigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.find_job_btn) MaterialButton findJobBtn;

    public static final String lang="en";
    ActionBarDrawerToggle toggle;
    GoogleMap googleMap;
    RetrofitInterface retrofitInterface;
   public static List<ServicesItem> servicesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
 retrofitInterface= RetrofitClientInstance.getRetrofitInstance();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav_menu);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                switch (id){

                    case  R.id.profile :
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        break;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                        break;

                    case R.id.contact_us:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        break;

                    case R.id.reviews:
                        startActivity(new Intent(getApplicationContext(), ReviewsActivity.class));
                        break;

                    case R.id.notifications:
                       
                        break;
                    case R.id.statistics:
                       // startActivity(new Intent(getApplicationContext(), StatisticsActivity.class));
                        startActivity(new Intent(getApplicationContext(), AddReviewActivity.class));

                        break;
                    case R.id.setting:
                        setLocale("en");
                        break;




                    default:


                }
                return true;

            }
        });


        findJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map=new HashMap<>();
                map.put("page",1);
                map.put("limit",1);
                map.put("api_token",SignInActivity.loginResponse.getToken());

                Call<ServiceResponse> call=retrofitInterface.getService(map);

                call.enqueue(new Callback<ServiceResponse>() {
                    @Override
                    public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                      servicesList=  response.body().getServices();
                        if (response.body().isStatus()) {
                            Intent intent=new Intent(getApplicationContext(), FindAJobActivity.class);
                            startActivity(intent);

                        }
                    }
                    @Override
                    public void onFailure(Call<ServiceResponse> call, Throwable t) {

                    }
                });


            }
        });


    }


    public void setLocale( String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        Configuration config = new Configuration();

        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

       Intent refresh = new Intent(this, HomeActivity.class);
      // refresh.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
       startActivity(refresh);

    }

    @Override
    public void onMapReady(GoogleMap googleMap1) {
        MapsInitializer.initialize(getApplicationContext());
        googleMap = googleMap1;
        googleMap1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap1.addMarker(new MarkerOptions().position(new LatLng(40.45, -74.8888)).title("the place")
                .snippet("dddddddddddddddddd"));
        CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(40.45, -74.8888)
        ).zoom(16).bearing(0).tilt(45).build();

        googleMap1.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }




}
