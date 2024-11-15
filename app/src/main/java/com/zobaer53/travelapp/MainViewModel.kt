package com.zobaer53.travelapp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import androidx.lifecycle.viewModelScope
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.domain.use_cases.GetAllLocationFromDBUseCase
import com.zobaer53.travelapp.domain.use_cases.GetLocationFromApiUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class MainViewModel  @Inject constructor(
    private val getLocationFromApiUseCase: GetLocationFromApiUseCase,
    private val getAllLocationFromDBUseCase : GetAllLocationFromDBUseCase
) : ViewModel() {
    val uiState = getAllLocationFromDBUseCase.invoke()
        .map { UiState(it) }
        .stateIn(viewModelScope, SharingStarted.Eagerly, UiState(emptyList()))

    init {
        getLocationFromApiUseCase.invoke()
    }
}

data class UiState(val data: List<LocationDetailsEntity>)