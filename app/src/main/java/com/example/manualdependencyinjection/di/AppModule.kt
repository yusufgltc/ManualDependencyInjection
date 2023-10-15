package com.example.manualdependencyinjection.di

import com.example.manualdependencyinjection.data.AuthApi
import com.example.manualdependencyinjection.domain.AuthRepository

interface AppModule {
    val authApi: AuthApi
    val authRepository: AuthRepository
}
