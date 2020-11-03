package com.example.habik.lineservice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button orderStatusBtn, repairCostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderStatusBtn = (Button)findViewById(R.id.orderStatusBtn);
        orderStatusBtn.setOnClickListener(this);
        repairCostBtn = (Button)findViewById(R.id.repairCostBtn);
        repairCostBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.repairCostBtn: {
                Intent intent = new Intent(MainActivity.this, RepairCostActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.orderStatusBtn: {
                Intent intent = new Intent(MainActivity.this, OrderStatusActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
