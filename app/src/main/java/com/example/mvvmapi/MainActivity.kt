package com.example.mvvmapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapi.api.QuoteInterface
import com.example.mvvmapi.api.RetrofitHelper
import com.example.mvvmapi.repository.QuotesRepository
import com.example.mvvmapi.viewmodel.QuoteFactory
import com.example.mvvmapi.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteInterface = RetrofitHelper.getInstance().create(QuoteInterface::class.java)
        val repository = QuotesRepository(quoteInterface)

        quoteViewModel =
            ViewModelProvider(this, QuoteFactory(repository)).get(QuoteViewModel::class.java)
        quoteViewModel.quotes.observe(this, Observer {
            Toast.makeText(this,"Show Data withOut",Toast.LENGTH_SHORT).show()
            it.data.memes.iterator().forEach { meme ->
                Log.d("TAGOut", "name: ${meme.name}\n image : ${meme.url}",)
                val output = findViewById<TextView>(R.id.outPut)
                output.text = it.data.memes.toString()
            }
        })

    }
}