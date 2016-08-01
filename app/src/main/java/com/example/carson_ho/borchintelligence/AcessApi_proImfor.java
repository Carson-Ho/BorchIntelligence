package com.example.carson_ho.borchintelligence;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Carson_Ho on 16/7/29.
 */

//显示商品详情通信接口
public interface AcessApi_proImfor{

        //注解采用@Post表示Post方法进行请求
//Retrofit把网络请求的URL分成了两部分,一部分baseurl放在Retrofit对象里,另一部分放在Service接口里
//如果接口里的url是一个完整的网址，那么baseurl的设置可以忽略
//填入完整API接口
        @POST("http://218.192.170.132:8000/commodity/display")
//Body只能用Okhttp的RequestBody
//getCall()是接受网络请求数据的方法
//其中返回类型为Call<*>,参数是接受数据的JavaBean
        Call<Pro_Imfor_JavaBean> getCall(@Body RequestBody body);
}


