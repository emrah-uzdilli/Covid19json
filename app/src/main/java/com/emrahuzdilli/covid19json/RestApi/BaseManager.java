package com.emrahuzdilli.covid19json.RestApi;

public class BaseManager {
    //extend kullanıcagımızdan protected kullanıyoruz....
    //protected erişim imleci
    protected RestApi getRestpiClient()
    {
        //RestApiClient'in nesnesini oluşturmaktayız...Ve burdanda direk RestApiClient class'ına gidicek
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url_bilgi);
        return restApiClient.getmRestApi();
    }
}
