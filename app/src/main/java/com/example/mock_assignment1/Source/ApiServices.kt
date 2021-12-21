package com.example.pagination.Source

import com.example.mock_assignment1.DataClasses.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("autocomplete?queryString=airtel")
    suspend fun getAddress(@Query("city") city:String) : ResponseModel
}