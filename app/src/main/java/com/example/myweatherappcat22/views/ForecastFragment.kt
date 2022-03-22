package com.example.myweatherappcat22.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myweatherappcat22.R
import com.example.myweatherappcat22.adapter.WeatherAdapter
import com.example.myweatherappcat22.databinding.FragmentForecastBinding
import com.example.myweatherappcat22.viewmodel.ResultState

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ForecastFragment : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentForecastBinding.inflate(layoutInflater)
    }

    private val weatherAdapter by lazy {
        WeatherAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.forecastRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = weatherAdapter
        }

        weatherViewModel.cityForecast.observe(viewLifecycleOwner, ::handleState)

        weatherViewModel.getForecast("Atlanta")

        return binding.root
    }

    private fun handleState(resultState: ResultState) {
        when(resultState) {
            is ResultState.LOADING -> {
                Toast.makeText(requireContext(), "LOADING...", Toast.LENGTH_LONG).show()
            }
            is ResultState.SUCCESS -> {
                weatherAdapter.setForecast(resultState.results.list)
            }
            is ResultState.ERROR -> {
                Log.e("FORECAST", resultState.error.localizedMessage, resultState.error)
                Toast.makeText(requireContext(), resultState.error.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
}