package com.example.jetpackcomponentscatalog

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun CrossfadeExampleAnimation(){
    var myComponentType:ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }
    
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType) {myComponentType ->
            when (myComponentType){
                ComponentType.Image -> Icon(
                    Icons.Default.Send,
                    contentDescription = ""
                )

                ComponentType.Text -> Text(text = "SOY COMPONENTE")
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Red)
                )
                ComponentType.Error -> Text(text = "ERROR")
            }
        }
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)){
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType(){
    Image, Text, Box, Error
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility (isVisible, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }

    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = {
            if (!smallSize) {
            }
        }
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })
}

@Composable
fun SizeAnimatio() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    val size by animateDpAsState(targetValue = if (smallSize) 50.dp else 100.dp)
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })
}

@Composable
fun ColorAnimationSimple() {
    var fistColor2 by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }

    val realColor2 by animateColorAsState(
        targetValue = if (fistColor2) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )

    if (showBox) {
        Column {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { fistColor2 = !fistColor2 })
        }
    }
}

@Composable
fun ColorAnimationSimpl() {
    var fistColor by rememberSaveable {
        mutableStateOf(false)
    }
    var realColor = if (fistColor) Color.Red else Color.Yellow

    var fistColor2 by rememberSaveable {
        mutableStateOf(false)
    }
    val realColor2 by animateColorAsState(targetValue = if (fistColor2) Color.Red else Color.Yellow)

    Column {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { fistColor = !fistColor })

        Spacer(modifier = Modifier.size(200.dp))

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { fistColor2 = !fistColor2 })
    }
}