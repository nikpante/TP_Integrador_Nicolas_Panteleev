package com.nicolaspanteleev.tpintegrador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.nicolaspanteleev.tpintegrador.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
//import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val text1 = viewModel.comparador.value?.textOne
        val text2 = viewModel.comparador.value?.textTwo
        assertEquals("", text1,text2)
    }

    @Test
    fun mainViewModel_CheckUpdateComparador() = runTest {
        launch {
            viewModel.updateComparador("Texto de prueba 1", "Texto de prueba 2")
        }
        advanceUntilIdle()
        assertEquals("Texto de prueba 1", viewModel.comparador.value?.textOne)
        assertEquals("Texto de prueba 2", viewModel.comparador.value?.textTwo)
    }

    @Test
    fun mainViewModel_CheckCompare() = runTest {
        launch {
            viewModel.updateComparador("Hola", "Hola")
        }
        advanceUntilIdle()
        val comparation = viewModel.comparador.value?.compare()
        assertEquals(true, comparation)
    }
}