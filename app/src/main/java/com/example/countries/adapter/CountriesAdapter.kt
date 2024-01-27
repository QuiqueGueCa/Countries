package com.example.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.Country
import com.example.countries.R
import com.example.countries.databinding.ItemCountryBinding

class CountriesAdapter(
    private val countries: List<Country>,
    private val listener: CountriesListener
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    interface CountriesListener {
        fun onCellClick(imgCountry: Int)
        fun onBtnClick(imgCity: Int)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCountryBinding.bind(view)

        fun setListener(country: Country) {
            binding.root.setOnClickListener {
                listener.onCellClick(country.img)
            }
            binding.btnCapital.setOnClickListener {
                listener.onBtnClick(country.imgCity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvNameCountry.text = countries[position].name

            setListener(countries[position])
        }
    }

    override fun getItemCount(): Int = countries.size
}