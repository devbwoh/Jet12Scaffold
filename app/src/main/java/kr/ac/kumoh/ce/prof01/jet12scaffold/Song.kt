package kr.ac.kumoh.ce.prof01.jet12scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.prof01.jet12scaffold.ui.theme.Jet12ScaffoldTheme

@Composable
fun SongScreen() {
    Scaffold(
        topBar = { SongTopBar() },
        bottomBar = {},
        snackbarHost = {},
        floatingActionButton = {},
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(
                "사랑은 늘 도망가",
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp),
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                "소주 한 잔",
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(8.dp),
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongTopBar() {
    TopAppBar(
        title = {
            Row {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "하트 아이콘"
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("나의 애창곡")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            titleContentColor = MaterialTheme.colorScheme.secondary,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SongScreenPreview() {
    Jet12ScaffoldTheme {
        SongScreen()
    }
}