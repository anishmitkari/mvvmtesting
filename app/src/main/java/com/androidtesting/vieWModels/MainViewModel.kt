package com.androidtesting.vieWModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidtesting.QuotesRepository.QuoteRepository
import com.androidtesting.models.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val respository: QuoteRepository) : ViewModel() {

    init {

        viewModelScope.launch(Dispatchers.IO) {
            respository.getQuotes(1)
        }

    }

    val quotes : LiveData<QuoteList>
    get() = respository.quotes
}