package com.mahmoud.bashir.tickets_system;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("TicketApi.php/5")
    Call<List<JSON>> getJSON();
}
