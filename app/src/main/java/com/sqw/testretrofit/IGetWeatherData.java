package com.sqw.testretrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface IGetWeatherData {

    @FormUrlEncoded
    @POST(".")
    public Call<WeatherModel> getWeather(@FieldMap Map<String ,String> map);
}
