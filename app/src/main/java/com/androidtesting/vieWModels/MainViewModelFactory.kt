package com.androidtesting.vieWModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidtesting.QuotesRepository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}