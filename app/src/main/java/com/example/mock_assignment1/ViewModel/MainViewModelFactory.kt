package com.example.mock_assignment1.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mock_assignment1.Repository.MyRepository

class MainViewModelFactory(private  val repo: MyRepository,private val city: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("ALI","Factory")
        return MyViewModel(repo,city) as T
    }
}