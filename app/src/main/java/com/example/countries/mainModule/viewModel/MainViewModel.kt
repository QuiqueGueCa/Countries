package com.example.countries.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.Country
import com.example.countries.mainModule.model.MainInteractor

class MainViewModel : ViewModel() {

    private val interactor: MainInteractor = MainInteractor()
    private val _countries = MutableLiveData<List<Country>>()

    init {
        _countries.value = interactor.getCountries()
    }


    val countries: LiveData<List<Country>> get() = _countries

}