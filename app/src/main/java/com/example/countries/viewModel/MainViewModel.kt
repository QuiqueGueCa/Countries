package com.example.countries.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.Country
import com.example.countries.model.MainInteractor

class MainViewModel : ViewModel() {

    private val interactor: MainInteractor = MainInteractor()
    private val _countries = MutableLiveData<List<Country>>()

    init {
        setData()
    }

    private fun setData() {
        _countries.value = interactor.getCountries()
    }

    val countries: LiveData<List<Country>> get() = _countries

}