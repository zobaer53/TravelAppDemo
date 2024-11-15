package com.zobaer53.travelapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface LocationDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationDetails(locationDetailsEntity: LocationDetailsEntity)

    @Query("SELECT * FROM LocationDetailsEntity")
    fun getAllLocationDetails(): Flow<List<LocationDetailsEntity>>
}