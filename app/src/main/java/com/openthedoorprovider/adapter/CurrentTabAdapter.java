package com.openthedoorprovider.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.button.MaterialButton;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoorprovider.R;
import com.openthedoorprovider.SelectServiceActivity;

public class CurrentTabAdapter extends RecyclerView.Adapter<CurrentTabAdapter.Holder> {

    Context context;
    View view;

    public CurrentTabAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public CurrentTabAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        view= LayoutInflater.from(context).inflate(R.layout.current_list_item,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentTabAdapter.Holder holder, final int i) {
      MaterialButton startService=(MaterialButton) holder.itemView.findViewById(R.id.start_service);

      startService.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              context.startActivity(new Intent(context, SelectServiceActivity.class));
          }
      });

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              show_popup(i);
          }
      });




    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder  extends RecyclerView.ViewHolder{


        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        }



    private void show_popup(final int position) {
        ImageView makeCall;
        Button cancelService_btn;
        MapView mapView;
        GoogleMap googleMap;

       // LayoutInflater myDialog=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View myDialog=inflater1.inflate(R.layout.activity_current_popup,null);
        final Dialog myDialog = new Dialog(context);


        myDialog.setCancelable(true);
        myDialog.setContentView(R.layout.activity_current_popup);
        makeCall = myDialog.findViewById(R.id.make_call);
       // cancelService_btn = myDialog.findViewById(R.id.cancel_service);
        mapView = myDialog.findViewById(R.id.map_view);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    googleMap = googleMap;
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(40.45, -74.8888)).title("the place"));
                    CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(40.45, -74.8888)
                    ).zoom(16).bearing(0).tilt(45).build();
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });
        }
//        cancelService_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.dismiss();
//                //Toast.makeText(getActivity(), "Cancel Service ..." + position, Toast.LENGTH_SHORT).show();
//            }
//        });
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                //Toast.makeText(getActivity(), "Make Call ..." + position, Toast.LENGTH_SHORT).show();
            }
        });

        myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ConstraintLayout layout=(ConstraintLayout) myDialog.findViewById(R.id.current_popup_layout);
        FrameLayout layout1=(FrameLayout) myDialog.findViewById(R.id.frame_root);



        layout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        layout1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        myDialog.show();
    }


}


