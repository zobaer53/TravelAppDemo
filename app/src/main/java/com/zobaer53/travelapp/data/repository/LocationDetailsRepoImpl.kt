package com.zobaer53.travelapp.data.repository

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.zobaer53.travelapp.data.local.LocationDetailsDao
import com.zobaer53.travelapp.data.worker.LocationDataFetchWorker
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.domain.repository.LocationDetailsRepository
import kotlinx.coroutines.flow.Flow

class LocationDetailsRepoImpl(
    private val workManager: WorkManager,
    private val dao: LocationDetailsDao
) : LocationDetailsRepository {
    override fun getLocationDetailsApi() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val workRequest = OneTimeWorkRequestBuilder<LocationDataFetchWorker>()
            .setConstraints(constraints)
            .build()
        workManager.enqueue(workRequest)
    }

    override fun getAllLocationDetails(): Flow<List<LocationDetailsEntity>> = dao.getAllLocationDetails()
}