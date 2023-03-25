package com.taqwa.plus


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taqwa.plus.ui.Nav
import com.taqwa.plus.ui.theme.QuranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranTheme {
                Nav()
            }
        }
    }
}
