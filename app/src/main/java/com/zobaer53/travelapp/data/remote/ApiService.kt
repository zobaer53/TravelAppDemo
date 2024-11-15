package com.zobaer53.travelapp.data.remote

import com.zobaer53.travelapp.data.remote.model.LocationDetailsDTO
import retrofit2.http.GET

interface ApiService {
    @GET
    suspend fun getLocationDetails(): LocationDetailsDTO
}