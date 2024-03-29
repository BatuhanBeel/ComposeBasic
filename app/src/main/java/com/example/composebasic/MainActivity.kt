package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constrains = ConstraintSet{
                val greenbox = createRefFor("greenbox")
                val redbox = createRefFor("redbox")
                val bluebox = createRefFor("bluebox")
                val blackbox = createRefFor("blackbox")
                val magentabox = createRefFor("magentabox")

                val topGuideline = createGuidelineFromTop(0.5f)

                constrain(greenbox){
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                constrain(redbox){
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                    top.linkTo(parent.top)
                    start.linkTo(greenbox.end)
                    end.linkTo(parent.end)
                }
                constrain(bluebox){
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    top.linkTo(topGuideline)
                    start.linkTo(greenbox.end)
                }
                constrain(blackbox){
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                constrain(magentabox){
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(magentabox.end)
                }
                createHorizontalChain(magentabox,blackbox, chainStyle = ChainStyle.Packed)
            }
            ConstraintLayout(constrains,
                modifier = Modifier.fillMaxSize()) {
                Box(Modifier
                    .background(Color.Green)
                    .layoutId("greenbox"))
                Box(Modifier
                    .background(Color.Red)
                    .layoutId("redbox"))
                Box(Modifier
                    .background(Color.Blue)
                    .layoutId("bluebox"))
                Box(Modifier
                    .background(Color.Black)
                    .layoutId("blackbox"))
                Box(Modifier
                    .background(Color.Magenta)
                    .layoutId("magentabox"))
            }
        }
    }
}
