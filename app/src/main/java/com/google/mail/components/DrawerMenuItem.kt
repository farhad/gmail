package com.google.mail.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.mail.R

sealed class DrawerMenuItem(
    val icon: ImageVector? = null,
    @StringRes val title: Int? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
) {
    object Inbox : DrawerMenuItem(
        icon = Icons.Rounded.Inbox,
        title = R.string.inbox,
    )

    object Divider : DrawerMenuItem(isDivider = true)

    object Starred : DrawerMenuItem(
        icon = Icons.Rounded.StarOutline,
        title = R.string.starred,
    )

    object Snoozed : DrawerMenuItem(
        icon = Icons.Rounded.Snooze,
        title = R.string.snoozed,
    )

    object Important : DrawerMenuItem(
        icon = Icons.Rounded.LabelImportant,
        title = R.string.important
    )

    object Sent : DrawerMenuItem(
        icon = Icons.Rounded.Send,
        title = R.string.sent
    )

    object Scheduled : DrawerMenuItem(
        icon = Icons.Rounded.Schedule,
        title = R.string.scheduled
    )

    object Drafts : DrawerMenuItem(
        icon = Icons.Rounded.Drafts,
        title = R.string.drafts
    )

    object AllMail : DrawerMenuItem(
        icon = Icons.Rounded.Mail,
        title = R.string.all_mail
    )

    object Spam : DrawerMenuItem(
        icon = Icons.Rounded.Report,
        title = R.string.spam
    )

    object Trash : DrawerMenuItem(
        icon = Icons.Rounded.Delete,
        title = R.string.trash
    )
}