package com.androidtesting

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidtesting.QuotesRepository.QuoteRepository
import com.androidtesting.api.QuoteService
import com.androidtesting.api.RetrofitHelper
import com.androidtesting.models.Result
import com.androidtesting.vieWModels.MainViewModel
import com.androidtesting.vieWModels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {

            Log.d(TAG, "onCreate: "+it.results.toString())
        })

    }


}