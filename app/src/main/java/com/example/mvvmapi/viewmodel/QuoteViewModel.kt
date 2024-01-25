package com.example.mvvmapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapi.model.Jokes
import com.example.mvvmapi.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository : QuotesRepository): ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes()
        }
    }
    val quotes : LiveData<Jokes>
        get() = repository.quotes
}