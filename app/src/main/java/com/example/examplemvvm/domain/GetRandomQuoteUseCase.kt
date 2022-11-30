package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel{
        val quotes = QuoteProvider.quotes
        val randomNumber = (quotes.indices).random()
        if (!quotes.isNullOrEmpty()){
            return quotes[randomNumber]
        }
        return QuoteModel(quote = "", author = "")
    }
}