package com.example.mock_assignment1.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mock_assignment1.DataClasses.ResponseModel
import com.example.mock_assignment1.Repository.MyRepository
import kotlinx.coroutines.launch


class MyViewModel (private val repo: MyRepository) : ViewModel() {
    private var liveDataList = MutableLiveData<ResponseModel>()

    fun getResults(city: String): LiveData<ResponseModel> {
        viewModelScope.launch {
            liveDataList.postValue(repo.getAddress(city))
        }
        return liveDataList
    }

}