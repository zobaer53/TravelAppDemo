package com.zobaer53.travelapp.data.worker


import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.zobaer53.travelapp.data.local.LocationDetailsDao
import com.zobaer53.travelapp.data.local.toEntity
import com.zobaer53.travelapp.data.remote.ApiService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class LocationDataFetchWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val dao: LocationDetailsDao
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        return try {
            val response = apiService.getLocationDetails().toEntity()
            dao.insertLocationDetails(response)
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}