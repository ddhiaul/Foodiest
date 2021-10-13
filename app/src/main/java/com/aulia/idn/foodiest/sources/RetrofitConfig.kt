package com.aulia.idn.foodiest.sources

import com.aulia.idn.foodiest.common.Constanta
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitConfig {
    private val retrofitConfiguration by lazy {
        Retrofit.Builder().baseUrl(Constanta().BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiSevicesClient: ApiSevice by lazy {
        retrofitConfiguration.create(ApiSevice::class.java)
    }
}