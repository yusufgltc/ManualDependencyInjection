package com.example.manualdependencyinjection

import com.example.manualdependencyinjection.data.AuthApi
import com.example.manualdependencyinjection.data.AuthRepositoryImpl
import com.example.manualdependencyinjection.data.LoginRequest
import com.example.manualdependencyinjection.domain.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class AuthRepositoryTest {

    @Mock
    private lateinit var mockAuthApi: AuthApi

    private lateinit var authRepository: AuthRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        authRepository = AuthRepositoryImpl(mockAuthApi)
    }

    @Test
    fun testLoginSuccess() = runBlocking {
        val username = "admin"
        val password = "admin"
        `when`(mockAuthApi.login(LoginRequest(username, password))).thenReturn(Unit)

        authRepository.login(username, password)

        verify(mockAuthApi).login(LoginRequest(username, password))
    }
}