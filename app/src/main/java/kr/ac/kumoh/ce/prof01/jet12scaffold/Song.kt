package kr.ac.kumoh.ce.prof01.jet12scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kr.ac.kumoh.ce.prof01.jet12scaffold.ui.theme.Jet12ScaffoldTheme

@Composable
fun SongScreen() {
    val snackbar = remember {
        SnackbarHostState()
    }
    Scaffold(
        topBar = { SongTopBar() },
        bottomBar = { SongBottomBar(snackbar) },
        snackbarHost = { SnackbarHost(snackbar) },
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

@Composable
fun SongBottomBar(snackbar: SnackbarHostState) {
    var searchText by rememberSaveable {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        leadingIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        snackbar.showSnackbar("노래 $searchText 검색")
                    }
                }
            ) {
                Icon(
                    Icons.Default.Search,
                    "검색 아이콘"
                )
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        placeholder = {
            Text("제목 검색")
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SongScreenPreview() {
    Jet12ScaffoldTheme {
        SongScreen()
    }
}