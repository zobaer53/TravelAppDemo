package com.zobaer53.travelapp.data.local

import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.data.remote.model.LocationDetailsDTO

fun LocationDetailsDTO.toEntity(): LocationDetailsEntity {
    return LocationDetailsEntity(
        propertyName = this.property_name,
        location = this.location,
        rating = this.rating,
        description = this.description,
        fare = this.fare,
        fareUnit = this.fare_unit,
        isAvailable = this.is_available,
        heroImage = this.hero_image,
        detailImage = this.detail_images, // Pass list
        currency = this.currency
    )
}
