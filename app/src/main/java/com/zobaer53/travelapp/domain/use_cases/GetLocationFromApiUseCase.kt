package com.zobaer53.travelapp.domain.use_cases

import com.zobaer53.travelapp.domain.repository.LocationDetailsRepository
import javax.inject.Inject

class GetLocationFromApiUseCase  @Inject constructor( private val repository: LocationDetailsRepository) {
     operator fun invoke() = repository.getLocationDetailsApi()
}