package com.zobaer53.travelapp.data.local

import com.zobaer53.travelapp.data.local.model.LocationDetailsEntity
import com.zobaer53.travelapp.data.remote.model.LocationDetailsApiResponse

fun LocationDetailsApiResponse.toEntity(): LocationDetailsEntity {
    return LocationDetailsEntity(
        propertyName = this.propertyName,
        location = this.location,
        rating = this.rating,
        description = this.description,
        fare = this.fare,
        fareUnit = this.fareUnit,
        isAvailable = this.isAvailable,
        heroImage = this.heroImage,
        detailImage = this.detailImage,
        currency = this.currency
    )
}
