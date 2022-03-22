package com.example.myweatherappcat22.views

import androidx.fragment.app.Fragment
import com.example.myweatherappcat22.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseFragment : Fragment() {

    protected val weatherViewModel: WeatherViewModel by viewModel()
}