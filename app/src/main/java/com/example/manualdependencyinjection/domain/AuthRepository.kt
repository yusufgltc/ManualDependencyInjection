package com.example.manualdependencyinjection.domain

interface AuthRepository {
    suspend fun login(username:String, password: String)
}