package com.zobaer53.travelapp.data.local



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity


@Database(entities = [LocationDetailsEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "ta_db")
                .build()
    }

    abstract fun getLocationDetailsDao(): LocationDetailsDao

}