package com.zobaer53.travelapp.view_model_test

import app.cash.turbine.test
import com.zobaer53.travelapp.MainViewModel
import com.zobaer53.travelapp.domain.model.LocationDetailsEntity
import com.zobaer53.travelapp.domain.use_cases.GetAllLocationFromDBUseCase
import com.zobaer53.travelapp.domain.use_cases.GetLocationFromApiUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val getLocationFromApiUseCase: GetLocationFromApiUseCase = mockk(relaxed = true)
    private val getAllLocationFromDBUseCase: GetAllLocationFromDBUseCase = mockk()
    private lateinit var viewModel: MainViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `uiState should emit data from getAllLocationFromDBUseCase`() = testScope.runTest {
        val fakeLocations = listOf(
            LocationDetailsEntity(
                id = 1,
                propertyName = "Mountain Retreat",
                location = "Aspen, USA",
                rating = 4.5,
                description = "A serene mountain retreat for your perfect getaway.",
                fare = 100.0,
                fareUnit = "NIGHT",
                isAvailable = true,
                heroImage = "hero_image1.jpg",
                detailImage = listOf("detail_image1.jpg", "detail_image2.jpg"),
                currency = "USD"
            ),
            LocationDetailsEntity(
                id = 2,
                propertyName = "City Apartment",
                location = "Berlin, Germany",
                rating = 3.8,
                description = "A cozy apartment in the heart of the city.",
                fare = 200.0,
                fareUnit = "DAY",
                isAvailable = false,
                heroImage = "hero_image2.jpg",
                detailImage = listOf("detail_image3.jpg", "detail_image4.jpg"),
                currency = "EUR"
            )
        )
        coEvery { getAllLocationFromDBUseCase.invoke() } returns flowOf(fakeLocations)

        viewModel = MainViewModel(getLocationFromApiUseCase, getAllLocationFromDBUseCase)

        viewModel.uiState.test {
            val emittedState = awaitItem()
            assertEquals(fakeLocations, emittedState.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `getLocationFromApiUseCase should be invoked during initialization`() = testScope.runTest {
        coEvery { getAllLocationFromDBUseCase.invoke() } returns flowOf(emptyList())

        viewModel = MainViewModel(getLocationFromApiUseCase, getAllLocationFromDBUseCase)

        coVerify { getLocationFromApiUseCase.invoke() }
    }

    @Test
    fun `uiState should handle empty data`() = testScope.runTest {
        coEvery { getAllLocationFromDBUseCase.invoke() } returns flowOf(emptyList())

        viewModel = MainViewModel(getLocationFromApiUseCase, getAllLocationFromDBUseCase)

        viewModel.uiState.test {
            val emittedState = awaitItem()
            assertEquals(emptyList<LocationDetailsEntity>(), emittedState.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState should handle errors from getAllLocationFromDBUseCase`() = testScope.runTest {
        val errorFlow: Flow<List<LocationDetailsEntity>> = flow { throw Exception("Database error") }
        coEvery { getAllLocationFromDBUseCase.invoke() } returns errorFlow

        viewModel = MainViewModel(getLocationFromApiUseCase, getAllLocationFromDBUseCase)

        viewModel.uiState.test {
            val emittedState = awaitItem()
            assertEquals(emptyList<LocationDetailsEntity>(), emittedState.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState should update correctly when data changes`() = testScope.runTest {
        val initialData = listOf(
            LocationDetailsEntity(
                id = 1,
                propertyName = "Initial Location",
                location = "Initial Place",
                rating = 4.0,
                description = "Initial description",
                fare = 50.0,
                fareUnit = "NIGHT",
                isAvailable = true,
                heroImage = "initial_hero.jpg",
                detailImage = listOf("initial_detail.jpg"),
                currency = "USD"
            )
        )
        val updatedData = listOf(
            LocationDetailsEntity(
                id = 2,
                propertyName = "Updated Location",
                location = "Updated Place",
                rating = 5.0,
                description = "Updated description",
                fare = 150.0,
                fareUnit = "DAY",
                isAvailable = false,
                heroImage = "updated_hero.jpg",
                detailImage = listOf("updated_detail.jpg"),
                currency = "EUR"
            )
        )
        val dataFlow = flow {
            emit(initialData)
            emit(updatedData)
        }
        coEvery { getAllLocationFromDBUseCase.invoke() } returns dataFlow

        viewModel = MainViewModel(getLocationFromApiUseCase, getAllLocationFromDBUseCase)

        viewModel.uiState.test {
            assertEquals(initialData, awaitItem().data)
            assertEquals(updatedData, awaitItem().data)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
