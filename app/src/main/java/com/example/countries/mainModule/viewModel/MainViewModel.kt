package com.example.countries.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.dataClasses.Country
import com.example.countries.mainModule.model.MainInteractor

class MainViewModel : ViewModel() {

    private val interactor: MainInteractor = MainInteractor()
    private val _countries = MutableLiveData<List<Country>>()
    private val _isVisibleList = MutableLiveData<Boolean>()

    init {
        _countries.value = interactor.getCountries()
    }

    private val isVisibleList: LiveData<Boolean> get() = _isVisibleList
    val countries: LiveData<List<Country>> get() = _countries

    fun getIsVisibleList(): LiveData<Boolean> {
        return isVisibleList
    }

    fun setIsVisibleList(isVisibleList: Boolean) {
        _isVisibleList.value = isVisibleList
    }
}