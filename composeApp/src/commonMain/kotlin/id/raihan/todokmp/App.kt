package id.raihan.todokmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import id.raihan.todokmp.ui.theme.darkScheme
import id.raihan.todokmp.ui.theme.lightScheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val color by mutableStateOf(
        if (isSystemInDarkTheme()) lightScheme else darkScheme
    )
    MaterialTheme(colorScheme = color) {


    }
}