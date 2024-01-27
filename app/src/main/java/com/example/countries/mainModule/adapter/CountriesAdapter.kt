package com.example.countries.mainModule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.dataClasses.Country
import com.example.countries.databinding.ItemCountryBinding

class CountriesAdapter(
    private var countries: List<Country>,
    private val listener: CountriesListener
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    interface CountriesListener {
        fun onClick(imgToShow: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCountryBinding.bind(view)
        fun setListener(country: Country) {
            binding.root.setOnClickListener { listener.onClick(country.img) }
            binding.btnCapital.setOnClickListener { listener.onClick(country.imgCity) }
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

    fun setCountries(countries: List<Country>) {
        this.countries = countries as MutableList<Country>
        notifyDataSetChanged()
    }
}