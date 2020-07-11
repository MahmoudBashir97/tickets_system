package com.mahmoud.bashir.tickets_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mahmoud.bashir.tickets_system.Retrofit.RetrofitJSON;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    ApiInterface apiInterface;
    Retrofit retrofit;
    RetrofitJSON retrofitJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = retrofitJSON.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);


        Call<List<JSON>> call = apiInterface.getJSON();
        call.enqueue(new Callback<List<JSON>>() {
            @Override
            public void onResponse(Call<List<JSON>> call, Response<List<JSON>> response) {

                for (int i=0 ; i < response.body().size();i++){
                    if (response.body().get(i).id == 2){
                        Toast.makeText(MainActivity.this, ""+response.body().get(i).customer_name, Toast.LENGTH_SHORT).show();

                    }
                }

                Log.d(TAG, "onResponse:JSON"+response.body());
            }

            @Override
            public void onFailure(Call<List<JSON>> call, Throwable t) {

            }
        });






    }

}