package com.zobaer53.travelapp.domain.repository

import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import kotlinx.coroutines.flow.Flow

interface LocationDetailsRepository {

    fun getLocationDetailsApi()

    fun getAllLocationDetails(): Flow<List<LocationDetailsEntity>>
}