package com.example.sample_mvvm_quotes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sample_mvvm_quotes_app.databinding.ActivityMainBinding
import com.example.sample_mvvm_quotes_app.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var viewModel: MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getDataFromApi()

        viewModel.loadingView.observe(this, Observer {
            binding.quoteString.visibility = (8-it)
            binding.loadingView.visibility = it
        })

        binding.fab.setOnClickListener { viewModel.getDataFromApi() }

    }
}
