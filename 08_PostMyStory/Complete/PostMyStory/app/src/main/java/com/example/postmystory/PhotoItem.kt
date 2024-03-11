package com.example.postmystory

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun PhotoItem(photo: String, onClick: (String) -> Unit) {
  AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
      .data(photo)
      .crossfade(true)
      .diskCachePolicy(CachePolicy.DISABLED).build(),
    contentDescription = null,
    modifier = Modifier.clickable(onClick = { onClick(photo) }),
    contentScale = ContentScale.FillWidth,
    placeholder = painterResource(id = R.drawable.now_loading)
  )
}

@Preview
@Composable
fun PhotoItemPreview() {
  PhotoItem(photo = "https://picsum.photos/200/200",
    onClick = { })
}