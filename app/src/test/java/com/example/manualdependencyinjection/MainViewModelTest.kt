package com.example.manualdependencyinjection

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.manualdependencyinjection.domain.AuthRepository
import com.example.manualdependencyinjection.presentatiton.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockAuthRepository: AuthRepository

    @Mock
    private lateinit var mockObserver: Observer<Unit>

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        mainViewModel = MainViewModel(mockAuthRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setupCoroutines() {
        Dispatchers.setMain(Dispatchers.Default)
    }

    @Test
    fun testLogin() = runBlocking {
        mainViewModel.login()
        verify(mockAuthRepository).login("admin", "admin")
    }
}