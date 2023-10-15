package com.example.manualdependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.manualdependencyinjection.presentatiton.MainViewModel
import com.example.manualdependencyinjection.ui.theme.ManualDependencyInjectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManualDependencyInjectionTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                Button(onClick = {
                    viewModel.login()
                }) {
                    Text(text = "Login")
                }
            }
        }
    }
}