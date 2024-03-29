package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            LazyColumn{
                itemsIndexed(
                    items = listOf("This", "is", "Jetpack", "Compose")
                ){ index, string ->
                    Text(
                        text = string,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        fontSize = 24.sp
                    )

                }
//  U can give item count or list both method appropriate.
//                items(5000){
//                    Text(
//                        text = "Item $it",
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp),
//                        fontSize = 24.sp
//                    )
//                }
            }


//  All items load so it can cause memory problem. You should use LazyColumn -> loads items when you scroll.
//            val scrollState = rememberScrollState()
//            Column(
//                modifier = Modifier.verticalScroll(scrollState),
//            ) {
//                for (i in 1..50){
//                    Text(
//                        text = "Item $i",
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
//                        fontSize = 24.sp
//                    )
//                }
//            }
        }
    }
}
