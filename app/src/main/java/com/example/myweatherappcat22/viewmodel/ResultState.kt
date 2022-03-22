package com.example.myweatherappcat22.viewmodel

import com.example.myweatherappcat22.model.Results

sealed class ResultState {
    object LOADING : ResultState()
    class SUCCESS(val results: Results) : ResultState()
    class ERROR(val error: Throwable) : ResultState()
}
