package com.example.mock_assignment1.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mock_assignment1.DataClasses.Address
import com.example.pagination.Source.ApiServices

class MyRepository (private  val apiServices: ApiServices) {
    lateinit var addressData:List<Address>
    private val addressLiveData=MutableLiveData<List<Address>>()
    val addressList : LiveData<List<Address>>
        get() = addressLiveData

    suspend fun getAddress(city:String)
    {
        val result=apiServices.getAddress(city)
        if(result!=null) {
            Log.d("ALI","Repo not null")
            addressData=result.data.addressList
            Log.d("ALI",addressData.size.toString())
            addressLiveData.postValue(addressData)
            Log.d("ALI","ll")
        }
        else
            Log.d("ALI","Repo null")
    }
}