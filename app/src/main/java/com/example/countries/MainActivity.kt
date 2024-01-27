package com.example.countries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countries.adapter.CountriesAdapter
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), CountriesAdapter.CountriesListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()


    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.countries.observe(this, Observer {
            // TODO: añadir la lista al adapter
        })
    }

    override fun onCellClick(imgCountry: Int) {
        TODO("Not yet implemented")
    }

    override fun onBtnClick(imgCity: Int) {
        TODO("Not yet implemented")
    }
}