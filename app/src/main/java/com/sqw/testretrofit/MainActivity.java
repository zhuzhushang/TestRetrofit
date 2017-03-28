package com.sqw.testretrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnClickListener{


    private Context context;
    private Button button;
    private TextView show_data_tv;
    private final String BASE_URL = "http://api.k780.com:88/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        viewInit();
    }

    private void viewInit() {

        button = (Button) findViewById(R.id.button);
        show_data_tv = (TextView) findViewById(R.id.show_data_tv);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button:

                getWeatherData();

                break;
        }

    }

    /**
     * 获取数据
     */
    private void getWeatherData() {

        Map<String, String> map = new HashMap<>();
        map.put("app", "weather.future");
        map.put("weaid", "1");
        map.put("appkey", "10003");
        map.put("sign", "59bc3ef6191eb9f747dd4e83c99f2a4");
        map.put("format", "json");

        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(okhttpClientBuilder.build()).build();
        IGetWeatherData iGetWeatherData = retrofit.create(IGetWeatherData.class);
        Call<WeatherModel> callWeatherModel = iGetWeatherData.getWeather(map);
        callWeatherModel.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {

                ToastUtils.show(context,"请求成功");
                show_data_tv.setText(" success : "+response.body().getSuccess()+"\n"
                        +" msgid : "+response.body().getMsgid()+"\n"
                        +" msg : "+response.body().getMsg());

            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

                ToastUtils.show(context,"请求失败");
            }
        });
    }
}
