package com.kabricks.loadairtimeuganda.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kabricks.loadairtimeuganda.R;
import com.kabricks.loadairtimeuganda.adapters.NetworksAdapter;
import com.kabricks.loadairtimeuganda.model.Networks;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NetworkChoice extends AppCompatActivity {

    @BindView(R.id.network_recycler) RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_choice);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NetworksAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
