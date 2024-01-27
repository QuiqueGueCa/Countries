package com.example.countries.mainModule

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countries.R
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.imgModule.ImgFragment
import com.example.countries.imgModule.viewModel.ImgViewModel
import com.example.countries.mainModule.adapter.CountriesAdapter
import com.example.countries.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), CountriesAdapter.CountriesListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var mImgViewModel: ImgViewModel
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
        mViewModel.countries.observe(this) {
            mAdapter.setCountries(it)
        }
        mViewModel.getIsVisibleList().observe(this) {
            binding.recyclerView.isVisible = it
        }
        mImgViewModel = ViewModelProvider(this)[ImgViewModel::class.java]
    }

    override fun onClick(imgToShow: Int) {
        mImgViewModel.setImg(imgToShow)
        launchImgFragment()
    }

    private fun launchImgFragment() {
        mViewModel.setIsVisibleList(false)
        val fragment = ImgFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerMain, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mViewModel.setIsVisibleList(true)
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}