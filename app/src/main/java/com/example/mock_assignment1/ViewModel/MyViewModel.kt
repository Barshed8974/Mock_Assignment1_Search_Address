package com.example.mock_assignment1.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mock_assignment1.DataClasses.Address
import com.example.mock_assignment1.Repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (private val repo: MyRepository,private val city:String) : ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            repo.getAddress(city)
        }
    }
    val address: LiveData<List<Address>>
        get() = repo.addressList

}