package com.example.manualdependencyinjection.data

import com.example.manualdependencyinjection.domain.AuthRepository
import java.lang.Exception

class AuthRepositoryImpl(
    private val api: AuthApi
): AuthRepository {

    override suspend fun login(username: String, password: String) {
        try {
//            val loginRequest  = LoginRequest(username, password)
//            api.login(loginRequest)
            println("Logging in...")
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }
}