package com.example.manualdependencyinjection.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
    suspend fun login(
        @Body body: LoginRequest
    )
}