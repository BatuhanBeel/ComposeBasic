package com.example.composebasic.produce_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

@Composable
fun produceStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0){
        while (value < countUpTo){
            delay(1000L)
            value++
        }
    }
//    this code equal above code
//    return flow<Int>{
//        var value = 0
//        emit(value)
//        while (value < countUpTo){
//            delay(1000L)
//            value++
//            emit(value)
//        }
//    }.collectAsState(initial = 0)
}

@Composable
fun loadNetworkImage(
    url: String,
    imageRepository: ImageRepository = ImageRepository()
): State<Result<Image>> {

    // Creates a State<T> with Result.Loading as initial value
    // If either `url` or `imageRepository` changes, the running producer
    // will cancel and will be re-launched with the new inputs.
    return produceState<Result<Image>>(initialValue = Result.Loading, url, imageRepository) {

        // In a coroutine, can make suspend calls
        val image = imageRepository.load(url)

        // Update State with either an Error or Success result.
        // This will trigger a recomposition where this State is read
        value = if (image == null) {
            Result.Error
        } else {
            Result.Success(image)
        }
    }
}