package com.example.myapplication.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp

@Composable
fun BlurText() {
    var checked by remember {
        mutableStateOf(true)
    }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp, label = "")
    Column {
        Text(
            modifier = Modifier
                .blur(radius = animatedBlur),
            text = "Blur Text",
            fontSize = MaterialTheme.typography.displaySmall.fontSize
        )
        //Spacer(modifier = Modifier.height(8.dp))
        Switch(checked = checked, onCheckedChange = { checked = !checked })
    }
}