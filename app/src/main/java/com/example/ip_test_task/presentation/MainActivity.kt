package com.example.ip_test_task.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ip_test_task.presentation.screens.MainScreen
import com.example.ip_test_task.presentation.viewmodels.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ItemViewModel = hiltViewModel()
            MainScreen(viewModel = viewModel)
        }
    }
}

