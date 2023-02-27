package com.google.mail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.mail.R

@Composable
fun DrawerMenu(scrollState: ScrollState) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        AppNameAndLogo()
        val menuItems = getMenuItems()
        repeat(menuItems.size) {
            DrawerMenuItem(drawerMenuItem = menuItems[it])
        }
    }
}

@Composable
fun AppNameAndLogo() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.gmail),
            modifier = Modifier.size(56.dp)
        )
        Text(
            text = stringResource(id = R.string.gmail),
            modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 0.dp),
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun DrawerMenuItem(drawerMenuItem: DrawerMenuItem) {
    when (drawerMenuItem) {
        is DrawerMenuItem.Divider -> {
            Divider(
                color = colorResource(id = R.color.gray_400),
                thickness = 1.dp,
                startIndent = 38.dp
            )
        }
        else -> {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(12.dp, 0.dp, 0.dp, 0.dp)
                    .clickable {

                    }
            ) {
                Image(
                    imageVector = drawerMenuItem.icon!!,
                    contentDescription = stringResource(id = drawerMenuItem.title!!),
                    colorFilter = ColorFilter.tint(
                        colorResource(id = R.color.gray_700)
                    )
                )
                Text(
                    text = stringResource(id = drawerMenuItem.title),
                    modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

fun getMenuItems() = listOf(
    DrawerMenuItem.Inbox,
    DrawerMenuItem.Divider,
    DrawerMenuItem.Starred,
    DrawerMenuItem.Snoozed,
    DrawerMenuItem.Important,
    DrawerMenuItem.Sent,
    DrawerMenuItem.Scheduled,
    DrawerMenuItem.Drafts,
    DrawerMenuItem.AllMail,
    DrawerMenuItem.Spam,
    DrawerMenuItem.Trash,
    DrawerMenuItem.Divider
)