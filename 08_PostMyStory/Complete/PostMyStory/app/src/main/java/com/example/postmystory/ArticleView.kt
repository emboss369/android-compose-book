package com.example.postmystory

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation

@Composable
fun ArticleView(message: Message) {
  Column {
    AsyncImage(
      modifier = Modifier
        .aspectRatio(1f)
        .padding(16.dp)
        .fillMaxWidth(),
      model = ImageRequest.Builder(LocalContext.current)
        .data(message.image)
        .crossfade(true)
        .diskCachePolicy(CachePolicy.DISABLED)
        .transformations(
          RoundedCornersTransformation(40f)
        )
        .build(),
      contentDescription = null,
      contentScale = ContentScale.FillWidth,
      placeholder = painterResource(id = R.drawable.now_loading)
    )
    Row(
      modifier = Modifier
        .padding(16.dp)
    ) {
      Icon(
        imageVector = Icons.Outlined.ThumbUp,
        contentDescription = null
      )
      Text(
        text = "「Nice!」 ${message.nice}件"
      )
    }
    var folding by remember { mutableStateOf(true) }
    Text(
      text = message.caption,
      maxLines = if (folding) 2 else Int.MAX_VALUE,
      overflow = TextOverflow.Ellipsis,
      modifier = Modifier
        .padding(16.dp)
        .clickable {
          folding = !folding
        }
    )
  }
}

@Preview
@Composable
fun ArticleViewPreview() {
  ArticleView(
    Message(
      caption = "Hello Android".repeat(20),
      image =
      "https://developer.android.com/static/images/brand/Android_Robot.png",
      nice = 999
    )
  )
}