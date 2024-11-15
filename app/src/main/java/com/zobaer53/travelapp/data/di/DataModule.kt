package com.zobaer53.travelapp.data.di

import android.content.Context
import androidx.work.WorkManager
import com.zobaer53.travelapp.data.local.AppDatabase
import com.zobaer53.travelapp.data.local.LocationDetailsDao
import com.zobaer53.travelapp.data.remote.ApiService
import com.zobaer53.travelapp.data.repository.LocationDetailsRepoImpl
import com.zobaer53.travelapp.domain.repository.LocationDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://9133e3e4055644b890c2ca078f3163ad.api.mockbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAPiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase): LocationDetailsDao {
        return appDatabase.getLocationDetailsDao()
    }

    @Provides
    @Singleton
    fun provideWorkmanager(@ApplicationContext context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }
    @Provides
    fun provideQuoteRepository(workManager: WorkManager, dao: LocationDetailsDao): LocationDetailsRepository {
        return LocationDetailsRepoImpl(workManager, dao)
    }
}