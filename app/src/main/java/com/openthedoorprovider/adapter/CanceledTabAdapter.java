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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.openthedoorprovider.R;

public class CanceledTabAdapter extends RecyclerView.Adapter<CanceledTabAdapter.Holder> {

    Context context;

    public CanceledTabAdapter(Context context) {
        this.context=context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.canceled_list_item,viewGroup,false);

        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(i);
            }

            private void showPopup(int i) {

                MapView mapView;
                GoogleMap googleMap;
                final Dialog myDialog = new Dialog(context);


                myDialog.setCancelable(true);
                myDialog.setContentView(R.layout.activity_canceled_popup);
                //makeCall = myDialog.findViewById(R.id.make_call);
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

                myDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                FrameLayout layout1=(FrameLayout) myDialog.findViewById(R.id.frame_root);



                layout1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                myDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder{
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
