package com.example.manualdependencyinjection.presentatiton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manualdependencyinjection.domain.AuthRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val authRepository: AuthRepository
): ViewModel() {

    fun login() {
        viewModelScope.launch {
            authRepository.login("admin", "admin")
        }
    }
}