package com.google.mail.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.google.mail.R

@Composable
fun ComposeFab(scrollState: ScrollState) {
    if (scrollState.value > 50) {
        ExtendedFloatingActionButton(
            text = { Text(text = stringResource(id = R.string.compose)) },
            icon = { Icon(imageVector = Icons.Rounded.Edit, contentDescription = null) },
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colors.surface
        )
    } else {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(imageVector = Icons.Rounded.Edit, contentDescription = null)
        }
    }
}