package com.example.games4you

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.games4you.ui.navigation.GameApp
import com.example.games4you.ui.theme.Game4YouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Game4YouTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}