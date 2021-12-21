package com.example.mock_assignment1.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mock_assignment1.DataClasses.AddressListItem
import com.example.mock_assignment1.DataClasses.ResponseModel
import com.example.pagination.Source.ApiServices

class MyRepository (private  val apiServices: ApiServices) {

    suspend fun getAddress(city:String):ResponseModel
    {
        val result=apiServices.getAddress(city)
        return result
    }
}