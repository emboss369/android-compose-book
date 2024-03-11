package com.example.postmystory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation

@Composable
fun CaptionScreen(
  selectUrl: String,
  onClick: () -> Unit,
  onChange: (String) -> Unit
) {
  var text by remember { mutableStateOf("") }
  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    AsyncImage(
      modifier = Modifier
        .size(200.dp)
        .aspectRatio(1f)
        .padding(16.dp),
      model = ImageRequest.Builder(LocalContext.current)
        .data(selectUrl)
        .crossfade(true)
        .diskCachePolicy(CachePolicy.DISABLED)
        .transformations(
          RoundedCornersTransformation(40f)
        )
        .build(),
      placeholder = painterResource(id = R.drawable.now_loading),
      contentDescription = null,
      contentScale = ContentScale.FillWidth
    )
    TextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      value = text,
      onValueChange = { newText ->
        text = newText
        onChange(newText)
      },
      label = { Text(text = "キャプションを入力してください") },
      maxLines = 15
    )
    Button(onClick = onClick) {
      Text(text = "投稿する")
    }
  }
}

@Preview
@Composable
fun CaptionScreenPreview() {
  CaptionScreen(
    selectUrl = "https://picsum.photos/200/200",
    onClick = { },
    onChange = { }
  )
}