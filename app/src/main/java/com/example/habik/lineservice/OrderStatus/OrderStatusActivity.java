package com.example.habik.lineservice.OrderStatus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habik.lineservice.API.NetworkService;
import com.example.habik.lineservice.Main.Constants;
import com.example.habik.lineservice.Main.MainActivity;
import com.example.habik.lineservice.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderStatusActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phoneNumberEt;
    Button orderStatusBtn;
    TextView orderInfoTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        orderInfoTv = (TextView) findViewById(R.id.orderStatusInfo);
        phoneNumberEt = (EditText) findViewById(R.id.phoneNumberEditText);
        orderStatusBtn = (Button) findViewById(R.id.orderStatusBtn);

        orderStatusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        NetworkService.getInstance().getJSONApi().getOrderStatus(MainActivity.currentToken, phoneNumberEt.getText().toString()).enqueue(new Callback<OrderInfo>() {
            @Override
            public void onResponse(Call<OrderInfo> call, Response<OrderInfo> response) {
                OrderInfo orderInfo = response.body();
                if(orderInfo != null &&orderInfo.getData().length !=0 && orderInfo.isSuccess()) {
                    String text = "";
                    for (int i = 0; i < orderInfo.getData().length; i++) {

                        String currentData =  (Constants.MODEL + orderInfo.getData()[i].getModel() +
                                Constants.MALFUNCTION + orderInfo.getData()[i].getMalfunction() +
                                Constants.ORDER_STATUS + orderInfo.getData()[i].getStatus().getName());
                        text = i == 0 ? currentData : text + "\n\n" + currentData;
                    }
                    orderInfoTv.setText(text);
                }
                else {
                    Toast.makeText(getApplicationContext(),Constants.WRONG_PHONE_NUMBER,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<OrderInfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), Constants.NETWORK_ERROR,Toast.LENGTH_LONG).show();
            }
        });

    }
}
