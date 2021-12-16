package com.example.mock_assignment1.View

import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mock_assignment1.R
import com.example.mock_assignment1.Repository.MyRepository
import com.example.mock_assignment1.ViewModel.MainViewModelFactory
import com.example.mock_assignment1.ViewModel.MyViewModel
import com.example.pagination.Source.NetworkHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import vp.videoplayer.mvvm.view.MyAdapter
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.FloatingSearchView.OnQueryChangeListener


class MainActivity : AppCompatActivity() {
    private var list= listOf<Address>()
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val address=NetworkHelper.getApiServices()
        Log.d("ALI","address")
        val repo=MyRepository(address)
        Log.d("ALI","MyRepository")

        Log.d("ALI","ViewModelProvider")
//        val mainViewModel= ViewModelProvider(this, MainViewModelFactory(repo,"delhi")).get(MyViewModel::class.java)
//        mainViewModel.address.observe(this, {
//
//            myAdapter = MyAdapter(this, it)
//            myAdapter.notifyDataSetChanged()
//            recycler.adapter = myAdapter
//            recycler.layoutManager = LinearLayoutManager(this)
//        })
        floating_search_view.setOnQueryChangeListener(OnQueryChangeListener { oldQuery, newQuery -> //get suggestions based on newQuery
            val mainViewModel= ViewModelProvider(this, MainViewModelFactory(repo,newQuery.toString())).get(MyViewModel::class.java)
            mainViewModel.address.observe(this, {
                floating_search_view.swapSuggestions(it)
            })
            //pass them on to the search view
        })
    }
}
