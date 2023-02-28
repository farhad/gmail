package com.google.mail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.google.mail.R
import com.google.mail.components.MailRowLayoutIds.AVATAR
import com.google.mail.components.MailRowLayoutIds.BODY
import com.google.mail.components.MailRowLayoutIds.SENDER
import com.google.mail.components.MailRowLayoutIds.STAR
import com.google.mail.components.MailRowLayoutIds.SUBJECT
import com.google.mail.components.MailRowLayoutIds.TIME_STAMP
import java.util.*

object MailRowLayoutIds {
    const val AVATAR = "avatar"
    const val SENDER = "sender"
    const val SUBJECT = "subject"
    const val BODY = "body"
    const val TIME_STAMP = "timestamp"
    const val STAR = "star"
}

@Composable
fun MailList(paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val constraintSet = ConstraintSet {
                val avatar = createRefFor(AVATAR)
                val sender = createRefFor(SENDER)
                val subject = createRefFor(SUBJECT)
                val body = createRefFor(BODY)
                val timeStamp = createRefFor(TIME_STAMP)
                val star = createRefFor(STAR)

                constrain(avatar) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }

                constrain(sender) {
                    top.linkTo(parent.top)
                    start.linkTo(avatar.end)
                    end.linkTo(timeStamp.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(subject) {
                    top.linkTo(sender.bottom)
                    start.linkTo(avatar.end)
                    end.linkTo(timeStamp.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(body) {
                    top.linkTo(subject.bottom)
                    start.linkTo(subject.start)
                    end.linkTo(timeStamp.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(timeStamp) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    height = Dimension.wrapContent
                    width = Dimension.wrapContent
                }

                constrain(star) {
                    end.linkTo(parent.end)
                    bottom.linkTo(body.bottom)
                }
            }
            items(MailItem.getList()) { item ->
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    constraintSet = constraintSet
                ) {
                    MailAvatar(item = item, modifier = Modifier.layoutId(AVATAR))

                    Text(
                        text = item.sender,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .layoutId(SENDER),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = item.subject,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .layoutId(SUBJECT),
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = item.body,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .layoutId(BODY),
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )

                    Text(
                        text = item.timeStamp,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .layoutId(TIME_STAMP),
                        textAlign = TextAlign.End,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Image(
                        modifier = Modifier.layoutId(STAR),
                        imageVector = Icons.Rounded.StarBorder,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.gray_700))
                    )
                }
            }
        }
    }

}

@Composable
fun MailAvatar(item: MailItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(end = 8.dp)
            .size(40.dp)
            .clip(CircleShape),
        elevation = 4.dp,
        backgroundColor = colorResource(id = R.color.gray_400)
    ) {
        Text(
            text = item.sender[0].toString().uppercase(Locale.getDefault()),
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}