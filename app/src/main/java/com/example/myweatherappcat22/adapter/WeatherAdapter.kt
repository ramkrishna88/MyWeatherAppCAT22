package com.example.myweatherappcat22.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweatherappcat22.databinding.ForcastItemBinding
import com.example.myweatherappcat22.model.Forecast
import com.example.myweatherappcat22.model.Main

class WeatherAdapter(
    private val forecastList: MutableList<Forecast> = mutableListOf()
) : RecyclerView.Adapter<ForecastViewHolder>() {

    fun setForecast(newForecast: List<Forecast>) {
        forecastList.clear()
        forecastList.addAll(newForecast)
        notifyItemRangeChanged(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = ForcastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bind(forecastList[position].main)

    override fun getItemCount(): Int = forecastList.size
}

class ForecastViewHolder(private val binding: ForcastItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(main: Main) {
        binding.weatherTemp.text = main.temp.toString()
    }
}