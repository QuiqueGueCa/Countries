package com.example.countries.imgModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImgViewModel : ViewModel() {

    private val _imgToShow = MutableLiveData<Int>()

    private val imgToShow: LiveData<Int> get() = _imgToShow


    fun setImg(imgResource: Int) {
        _imgToShow.value = imgResource
    }

    fun getImg(): LiveData<Int> {
        return imgToShow
    }
}