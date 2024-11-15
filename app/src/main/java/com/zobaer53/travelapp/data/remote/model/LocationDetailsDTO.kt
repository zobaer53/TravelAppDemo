package com.zobaer53.travelapp.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class LocationDetailsDTO(
    @SerialName("property_name") val propertyName: String,
    @SerialName("location") val location: String,
    @SerialName("rating") val rating: Double,
    @SerialName("description") val description: String,
    @SerialName("fare") val fare: Double,
    @SerialName("fare_unit") val fareUnit: String,
    @SerialName("is_available") val isAvailable: Boolean,
    @SerialName("hero_image") val heroImage: String,
    @SerialName("detail_image") val detailImage: String,
    @SerialName("currency") val currency: String
)



