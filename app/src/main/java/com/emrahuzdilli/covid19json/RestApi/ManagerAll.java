package com.emrahuzdilli.covid19json.RestApi;

import com.emrahuzdilli.covid19json.Models.Bilgi;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
     //Class'ın kendisini döndürmesini sağlamakta.
    //ManagerAll Clasına ait bir nesne ınstance oluşturuldu..
    private static ManagerAll ourgetInstanse = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        //getInstance() methodu bu class'ın nesnesini döndürmekte...
        return ourgetInstanse;
    }
    //getirBilgi() bu fonksiyonu çagır
    //Bu Fonksiyon bize cevap döndürecek..
    public Call<List<Bilgi>> getirBilgi()
    {
        //yukarıdaki fonksiyonu çagırdığında getRestpiClient() gidicek yani Basemenager class'ına gidicek...Ordan RestApiClient'de nesne oluşturduktan sonra getir() fonkisyonunu döndürüp x e atama yapıcak..

        Call<List<Bilgi>> x = getRestpiClient().getir();
        return x;
    }
}
