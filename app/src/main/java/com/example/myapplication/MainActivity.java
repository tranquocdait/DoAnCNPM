package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://travel-now-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonProvinceAPI jsonProvinceAPI = retrofit.create(JsonProvinceAPI.class);
        Call<StatusProvince> call = jsonProvinceAPI.getListProvince();
        call.enqueue(new Callback<StatusProvince>() {
            @Override
            public void onResponse(Call<StatusProvince> call, Response<StatusProvince> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code:" + response.code());
                    return;
                }
                StatusProvince statusProvince = response.body();
                List<Province> provinces = statusProvince.getData();
                for (Province province : provinces) {
                    String content = "";
                    content += "Id: " + province.getId() + "\n";
                    content += "nameProvince: " + province.getNameProvince() + "\n";
                    content += "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<StatusProvince> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
