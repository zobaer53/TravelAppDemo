package com.zobaer53.travelapp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LocationDetailsDTO(
    val property_name: String,
    val location: String,
    val rating: Double,
    val description: String,
    val fare: Double,
    val fare_unit: String,
    val is_available: Boolean,
    val hero_image: String,
    val detail_images: List<String>,
    val currency: String
)



