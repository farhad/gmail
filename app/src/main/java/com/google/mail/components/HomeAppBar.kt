package com.google.mail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.google.mail.R
import com.google.mail.components.LayoutIds.MENU_ICON
import com.google.mail.components.LayoutIds.PROFILE_AVATAR
import com.google.mail.components.LayoutIds.SEARCH_TEXT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object LayoutIds {
    const val MENU_ICON = "menuIcon"
    const val SEARCH_TEXT = "searchText"
    const val PROFILE_AVATAR = "profileAvatar"
}

@Composable
fun HomeAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp,
            modifier = Modifier.requiredHeight(50.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                constraintSet = getConstraintSet()
            ) {
                IconButton(modifier = Modifier.layoutId(MENU_ICON), onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(
                        Icons.Default.Menu,
                        stringResource(R.string.menu)
                    )
                }

                Text(
                    text = stringResource(R.string.search_hint),
                    color = colorResource(id = R.color.gray_400),
                    modifier = Modifier.layoutId(SEARCH_TEXT),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start
                )

                Image(
                    painter = painterResource(id = R.drawable.kitty),
                    contentDescription = stringResource(
                        R.string.profile_avatar_content_desc
                    ),
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .layoutId(PROFILE_AVATAR)
                        .background(Color.LightGray)
                        .scale(0.8f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

fun getConstraintSet(): ConstraintSet = ConstraintSet {
    val menuIcon = createRefFor(MENU_ICON)
    val searchText = createRefFor(SEARCH_TEXT)
    val profileAvatar = createRefFor(PROFILE_AVATAR)

    constrain(menuIcon) {
        start.linkTo(parent.start)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }

    constrain(searchText) {
        start.linkTo(menuIcon.end)
        end.linkTo(profileAvatar.start)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
        width = Dimension.fillToConstraints
    }

    constrain(profileAvatar) {
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }
}