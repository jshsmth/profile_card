package com.example.profile_card.android

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(title: String, icon: ImageVector, IconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = { Icon(icon,
            contentDescription = "Home Icon",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clickable { IconClickAction.invoke() }) },
        title = { Text(text = title) }
    )
}

