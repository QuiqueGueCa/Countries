package com.example.countries.mainModule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countries.R
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.mainModule.adapter.CountriesAdapter
import com.example.countries.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), CountriesAdapter.CountriesListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: CountriesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        mAdapter = CountriesAdapter(mutableListOf(), this)
        val gridLayout = GridLayoutManager(this, resources.getInteger(R.integer.num_columns))

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = mAdapter
        }
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mViewModel.countries.observe(this, Observer {
            mAdapter.setCountries(it)
        })
    }

    override fun onCellClick(imgCountry: Int) {
        TODO("Not yet implemented")
    }

    override fun onBtnClick(imgCity: Int) {
        TODO("Not yet implemented")
    }
}