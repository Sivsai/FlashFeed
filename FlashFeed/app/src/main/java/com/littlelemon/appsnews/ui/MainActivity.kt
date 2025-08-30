package com.littlelemon.appsnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.littlelemon.appsnews.ui.navigation.AppNavigationGraph
import com.littlelemon.appsnews.ui.theme.AppsnewsTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            AppsnewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    AppEntryPoint()
                }
            }
        }
    }
}
@Composable
fun AppEntryPoint(){
AppNavigationGraph()
}
