package com.google.mail.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.mail.R

@Composable
fun BottomBar() {

    val items = listOf(BottomMenuItem.Mail, BottomMenuItem.Meet)

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.gray_700),
        elevation = 4.dp
    ) {
        items.forEach {
            BottomNavigationItem(selected = it.title == R.string.mail, onClick = { /*TODO*/ },
                label = { Text(text = stringResource(id = it.title)) },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = stringResource(id = it.title)
                    )
                })
        }
    }

}