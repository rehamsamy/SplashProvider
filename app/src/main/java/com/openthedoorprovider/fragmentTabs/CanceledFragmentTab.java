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

import com.openthedoorprovider.R;
import com.openthedoorprovider.adapter.CanceledTabAdapter;
import com.openthedoorprovider.adapter.CompletedTabAdapter;

public class CanceledFragmentTab extends Fragment {

    public CanceledFragmentTab() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_canceled_tab,container,false);

        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.canceled_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CanceledTabAdapter adapter=new CanceledTabAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
