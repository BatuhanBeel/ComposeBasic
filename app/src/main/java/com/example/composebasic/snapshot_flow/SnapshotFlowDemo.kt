package com.example.composebasic.snapshot_flow

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

@Composable
fun SnapshotFlowDemo() {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    LaunchedEffect(key1 = snackbarHostState){
        snapshotFlow { snackbarHostState }
            .mapNotNull { it.currentSnackbarData?.message }
            .distinctUntilChanged()
            .collect{ message ->
                println("A snackbar with message $message was shown")
            }
    }
}


/*
 val listState = rememberLazyListState()

LazyColumn(state = listState) {
    // ...
}

LaunchedEffect(listState) {
    snapshotFlow { listState.firstVisibleItemIndex }
        .map { index -> index > 0 }
        .distinctUntilChanged()
        .filter { it == true }
        .collect {
            MyAnalyticsService.sendScrolledPastFirstItemEvent()
        }
}
*/