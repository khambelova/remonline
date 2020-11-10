package com.example.habik.lineservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderStatusActivity extends AppCompatActivity implements View.OnClickListener {
    EditText phoneNumber;
    Button orderStatusBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        phoneNumber = (EditText)findViewById(R.id.phoneNumberEditText);
        orderStatusBtn = (Button)findViewById(R.id.orderStatusBtn);
        orderStatusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO: сделать проверки на корректный ввод телефона
        Toast.makeText(getApplicationContext(),Constants.CURRENT_ORDER_STATUS,Toast.LENGTH_LONG).show();
    }
}
