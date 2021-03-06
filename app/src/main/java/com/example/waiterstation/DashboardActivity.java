package com.example.waiterstation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.waiterstation.DRVInterface.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRecyclerAdapter staticRecyclerAdapter;
    List<DynamicRVModel> items = new ArrayList<>();
    DynamicRVAdapter dynamicRVAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ArrayList<StaticRecyclerModel> item = new ArrayList<>();
        item.add(new StaticRecyclerModel(R.drawable.pizza, "Pizza"));
        item.add(new StaticRecyclerModel(R.drawable.hamburger, "Burger"));
        item.add(new StaticRecyclerModel(R.drawable.pizza, "Pizza"));
        item.add(new StaticRecyclerModel(R.drawable.hamburger, "Burger"));
        item.add(new StaticRecyclerModel(R.drawable.pizza, "Pizza"));
        item.add(new StaticRecyclerModel(R.drawable.hamburger, "Burger"));
        item.add(new StaticRecyclerModel(R.drawable.pizza, "Pizza"));
        item.add(new StaticRecyclerModel(R.drawable.hamburger, "Burger"));

        recyclerView = findViewById(R.id.rv_1);
        staticRecyclerAdapter = new StaticRecyclerAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRecyclerAdapter);

        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Burger"));

        RecyclerView drv = findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRVAdapter = new DynamicRVAdapter(drv, this,items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 10) {
                    item.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size() - 1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end = index + 10;

                            for (int i = index; i < end; i++) {
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                            }

                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();
                        }
                    }, 4000);
                } else {
                    Toast.makeText(DashboardActivity.this, "Data Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}