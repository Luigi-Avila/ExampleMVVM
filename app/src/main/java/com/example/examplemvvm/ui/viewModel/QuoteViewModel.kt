package com.example.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    var getQuotesUseCase = GetQuotesUseCase()

    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote(){
       val result = getRandomQuoteUseCase()
        if(!result.quote.isNullOrEmpty()){
            quoteModel.postValue(result)
        }

    }
}