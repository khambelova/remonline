package com.example.habik.lineservice.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.habik.lineservice.API.NetworkService;
import com.example.habik.lineservice.OrderStatus.OrderStatusActivity;
import com.example.habik.lineservice.R;
import com.example.habik.lineservice.RepairCost.RepairCostActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button orderStatusBtn, repairCostBtn;
    public static String currentToken = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderStatusBtn = (Button)findViewById(R.id.orderStatusBtn);
        orderStatusBtn.setOnClickListener(this);
        repairCostBtn = (Button)findViewById(R.id.repairCostBtn);
        repairCostBtn.setOnClickListener(this);
        getToken();

    }

    public void getToken(){

        NetworkService.getInstance().getJSONApi().getToken(Constants.API_KEY).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token token = response.body();
                if (token.isSuccess()){
                    System.out.println("11111111");
                    currentToken = token.getToken();

                }
                else {
                    Toast.makeText(getApplicationContext(), Constants.WRONG_API_KEY, Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Constants.NETWORK_ERROR, Toast.LENGTH_LONG).show();
            }
        });

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
