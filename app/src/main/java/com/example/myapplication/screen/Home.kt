package com.example.myapplication.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.myapplication.HyperlinkText
import com.example.myapplication.widgets.BlurText
import com.example.myapplication.widgets.SelectableItem
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home() {
    val navigationBarItems = remember {
        NavigationBarItems.values()
    }
    var selectIndex by remember {
        mutableIntStateOf(0)
    }
    var selectedItem by remember {
        mutableStateOf(false)
    }
    var selectedItem2 by remember {
        mutableStateOf(true)
    }

    Scaffold(
        modifier = Modifier
            .padding(all = 12.dp),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .height(64.dp),
                selectedIndex = selectIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach { items ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable { selectIndex = items.ordinal },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(26.dp),
                            imageVector = items.icon,
                            contentDescription = "",
                            tint = if(selectIndex == items.ordinal) MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        },
        content = {
            Column {
                HyperlinkText(
                    fullText = "By signing in, you agree to the privacy policy and terms of use.",
                    linkText = listOf("privacy policy", "terms of use"),
                    hyperlinks = listOf("https://jobinja.ir/", "https://www.youtube.com/"),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
                BlurText()
                SelectableItem(selected = selectedItem, title = "Lorem Ipsum") {
                    selectedItem = !selectedItem
                }
                Spacer(modifier = Modifier.height(4.dp))
                SelectableItem(selected = selectedItem2, title = "Lorem Ipsum") {
                    selectedItem2 = !selectedItem2
                }
            }
        }
    )

}

enum class NavigationBarItems(val icon: ImageVector) {
    Person(icon = Icons.Default.Person),
    Call(icon = Icons.Default.Call),
    Setting(icon = Icons.Default.Settings)
}


@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember {
            MutableInteractionSource()
        }
    ) {
        onClick()
    }
}