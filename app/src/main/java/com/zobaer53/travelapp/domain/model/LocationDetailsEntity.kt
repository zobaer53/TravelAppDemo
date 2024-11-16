package com.zobaer53.travelapp.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationDetailsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Auto-generated primary key
    val propertyName: String,
    val location: String,
    val rating: Double,
    val description: String,
    val fare: Double,
    val fareUnit: String,
    val isAvailable: Boolean,
    val heroImage: String,
    val detailImage:  List<String>,
    val currency: String
)
