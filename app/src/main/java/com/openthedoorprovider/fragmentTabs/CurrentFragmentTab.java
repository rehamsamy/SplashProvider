package com.openthedoorprovider.fragmentTabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.openthedoorprovider.R;
import com.openthedoorprovider.adapter.CanceledTabAdapter;
import com.openthedoorprovider.adapter.CurrentTabAdapter;
import com.openthedoorprovider.adapter.InprocessTabAdapter;

public class CurrentFragmentTab extends Fragment {

    public CurrentFragmentTab() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_current_tab,container,false);


        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.current_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CurrentTabAdapter adapter=new CurrentTabAdapter(getContext());
        recyclerView.setAdapter(adapter);



        return view;
    }
}
