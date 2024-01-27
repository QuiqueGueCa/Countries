package com.example.countries.model

import com.example.countries.Country
import com.example.countries.R

class MainInteractor {
    fun getCountries(): List<Country> {
        return listOf(
            Country("Japón", R.drawable.japan, R.drawable.tokio),
            Country("Perú", R.drawable.peru, R.drawable.lima),
            Country("Suecia", R.drawable.sweden, R.drawable.stokholm),
            Country("Escocia", R.drawable.scotland, R.drawable.edimburgh)
        )
    }
}