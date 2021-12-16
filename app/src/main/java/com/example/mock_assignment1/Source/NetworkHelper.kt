package com.example.pagination.Source

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkHelper {
    private val httpLoggingInterceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private fun getNetworkInstance():Retrofit
    {
        Log.d("ALI","Network")
        return Retrofit.Builder()
            .baseUrl("https://digi-api.airtel.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            .build()
    }
    fun getApiServices():ApiServices= getNetworkInstance().create()
}