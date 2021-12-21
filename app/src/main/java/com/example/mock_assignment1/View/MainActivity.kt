package com.example.mock_assignment1.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.example.mock_assignment1.DataClasses.ResponseModel
import com.example.mock_assignment1.R
import com.example.mock_assignment1.Repository.MyRepository
import com.example.mock_assignment1.ViewModel.MainViewModelFactory
import com.example.mock_assignment1.ViewModel.MyViewModel
import com.example.pagination.Source.NetworkHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  repository=MyRepository(NetworkHelper.getApiServices())
        val viewModel=ViewModelProviders.of(this,MainViewModelFactory(repository)).get(MyViewModel::class.java)

        floating_search_view.setOnQueryChangeListener(FloatingSearchView.OnQueryChangeListener { oldQuery, newQuery -> //get suggestions based on newQuery
            viewModel.getResults(newQuery).observe(this@MainActivity, Observer {
                floating_search_view.swapSuggestions(getSuggestions(it))
            })
        })

    }

    private fun getSuggestions(it: ResponseModel?): MutableList<out SearchSuggestion>? {
        val suggestionsList = ArrayList<Suggestions>()
        val list = it?.data?.addressList

        list?.forEach {
            val suggestion = Suggestions(it!!.addressString!!)
            suggestionsList.add(suggestion)
        }
        return suggestionsList
    }
}