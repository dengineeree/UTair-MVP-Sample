package com.utair.domain.flightorder

import com.utair.data.cities.CityRepository
import com.utair.data.global.UTairPreferences
import com.utair.domain.global.models.FlightOrderData
import com.utair.presentation.mvp.flightorder.PassengersData
import javax.inject.Inject

class MainInteractor @Inject constructor(
        private val prefs: UTairPreferences,
        private val passengersDataValidator: PassengersDataValidator,
        private val flightOrderDataValidator: FlightOrderDataValidator,
        private val cityRepository: CityRepository
) {

    fun getFlightOrderData(): FlightOrderData {
        return prefs.getFlightOrderData()
    }

    fun saveFlightOrderData(flightOrderData: FlightOrderData) {
        prefs.saveOrderData(flightOrderData)
    }

    suspend fun getCities(): List<String> {
        return cityRepository.getCitiesList()
    }

    fun validatePassengersData(data: PassengersData) {
        return passengersDataValidator.validate(data)
    }

    fun validateFlightOrderData(data: FlightOrderData) {
        return flightOrderDataValidator.validate(data)
    }

}