package com.example.manualdependencyinjection.di

import android.content.Context
import com.example.manualdependencyinjection.data.AuthApi
import com.example.manualdependencyinjection.data.AuthRepositoryImpl
import com.example.manualdependencyinjection.domain.AuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class AppModuleImpl(
    private val appContext: Context
): AppModule {
    override val authApi: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://my-url.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }
}