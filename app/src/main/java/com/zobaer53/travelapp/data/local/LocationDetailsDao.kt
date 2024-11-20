package com.zobaer53.travelapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface LocationDetailsDao {

    @Transaction
    fun replaceLocationDetails(locationDetailsEntities: List<LocationDetailsEntity>) {
        clearLocationDetails()
        insertLocationDetails(locationDetailsEntities)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocationDetails(locationDetailsEntities: List<LocationDetailsEntity>)

    @Query("DELETE FROM LocationDetailsEntity")
    fun clearLocationDetails()

    @Query("SELECT * FROM LocationDetailsEntity")
    fun getAllLocationDetails(): Flow<List<LocationDetailsEntity>>
}
