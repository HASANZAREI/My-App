package com.example.myapplication.widgets

import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    titleColor: Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    titleSize: TextUnit = MaterialTheme.typography.labelLarge.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subTitle: String? = null,
    subTitleColor: Color =
        if (selected) MaterialTheme.colorScheme.onSurface
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    subTitleSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    subTitleWeight: FontWeight = FontWeight.Medium,
    borderWidth: Dp = 1.dp,
    borderColor: Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    borderShape: Shape = RoundedCornerShape(size = 10.dp),
    icon: ImageVector =
        if (selected) Icons.Default.CheckCircle
        else Icons.Default.Close,
    iconColor: Color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onSurface.copy(0.2f),
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .border(width = borderWidth, color = borderColor, shape = borderShape)
            .clip(borderShape)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(8f),
                text = title,
                fontWeight = titleWeight,
                fontSize = titleSize,
                color = titleColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(
                modifier = Modifier
                    .weight(2f),
                onClick = onClick
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = iconColor
                )
            }
        }
        if (subTitle != null) {
            Text(
                modifier = Modifier
                    .weight(8f),
                text = subTitle,
                fontWeight = subTitleWeight,
                fontSize = subTitleSize,
                color = subTitleColor,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
















