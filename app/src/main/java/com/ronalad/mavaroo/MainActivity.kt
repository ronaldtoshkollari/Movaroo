package com.ronalad.mavaroo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ronalad.mavaroo.navigation.Navigation
import com.ronalad.mavaroo.ui.theme.MovarooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovarooTheme {
                Navigation()
            }
        }
    }
}
