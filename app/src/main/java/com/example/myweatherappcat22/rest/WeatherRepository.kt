package com.example.myweatherappcat22.rest

import com.example.myweatherappcat22.model.Results
import retrofit2.Response

class WeatherRepositoryImpl(
    private val weatherServiceApi: ServiceApi
) : WeatherRepository {

    override suspend fun getCityForecast(city: String): Response<Results> {
        return weatherServiceApi.getForecast(city = city)
    }
}

interface WeatherRepository {
    suspend fun getCityForecast(city: String): Response<Results>
}