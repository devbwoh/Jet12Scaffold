package kr.ac.kumoh.ce.prof01.jet12scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.ac.kumoh.ce.prof01.jet12scaffold.ui.theme.Jet12ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jet12ScaffoldTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SongScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Jet12ScaffoldTheme {
        MainScreen()
    }
}