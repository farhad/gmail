package com.google.mail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.google.mail.R
import com.google.mail.components.LayoutIds.MENU_ICON
import com.google.mail.components.LayoutIds.PROFILE_AVATAR
import com.google.mail.components.LayoutIds.SEARCH_TEXT
import com.google.mail.ui.theme.LightGray

object LayoutIds {
    const val MENU_ICON = "menuIcon"
    const val SEARCH_TEXT = "searchText"
    const val PROFILE_AVATAR = "profileAvatar"
}

@Composable
fun HomeAppBar() {
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
                Icon(
                    Icons.Default.Menu,
                    stringResource(R.string.menu),
                    modifier = Modifier.layoutId(MENU_ICON)
                )

                Text(
                    text = stringResource(R.string.search_hint),
                    color = LightGray,
                    modifier = Modifier
                        .layoutId(SEARCH_TEXT)
                        .padding(16.dp, 0.dp, 0.dp, 0.dp),
                    style = MaterialTheme.typography.body2
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
    }

    constrain(profileAvatar) {
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }
}