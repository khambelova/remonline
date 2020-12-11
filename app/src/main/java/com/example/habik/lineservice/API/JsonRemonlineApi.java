package com.example.habik.lineservice.API;


import com.example.habik.lineservice.OrderStatus.OrderInfo;
import com.example.habik.lineservice.Main.Token;
import com.example.habik.lineservice.RepairCost.Problem;
import com.example.habik.lineservice.RepairCost.Services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonRemonlineApi {
    @POST("/token/new")
    Call<Token> getToken(@Query("api_key" ) String api_key);

    @GET("/order/")
    Call<OrderInfo> getOrderStatus(@Query("token") String token, @Query("client_phones[]") String clientPhone);

    @GET("/books/service-operations/")
    Call<Services> getServicesPrices(@Query("token") String token);
}