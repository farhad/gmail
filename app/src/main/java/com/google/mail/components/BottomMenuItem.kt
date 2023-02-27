package com.google.mail.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.mail.R

sealed class BottomMenuItem(val icon: ImageVector, @StringRes val title: Int) {

    object Mail : BottomMenuItem(icon = Icons.Rounded.Mail, title = R.string.mail)

    object Meet : BottomMenuItem(icon = Icons.Rounded.VideoCall, title = R.string.meet)
}