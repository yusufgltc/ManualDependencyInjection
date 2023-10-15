package com.example.manualdependencyinjection.presentatiton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manualdependencyinjection.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    fun login() {
        viewModelScope.launch {
            authRepository.login("admin", "admin")
        }
    }
}