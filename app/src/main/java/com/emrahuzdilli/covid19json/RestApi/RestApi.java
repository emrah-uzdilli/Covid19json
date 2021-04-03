package com.emrahuzdilli.covid19json.RestApi;


import com.emrahuzdilli.covid19json.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/v2/datasets/LYeOfHQwsv7FsfdGV/items?format=json&clean=1")
    Call<List<Bilgi>> getir();
}
