package com.zobaer53.travelapp.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mountain_safari")
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
    val detailImage: String,
    val currency: String
)
