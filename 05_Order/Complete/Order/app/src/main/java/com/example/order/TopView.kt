package com.example.order

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.order.ui.theme.BaseColor
import com.example.order.ui.theme.Lime600
import com.example.order.ui.theme.Orange400
import com.example.order.ui.theme.Orange900

@Composable
fun TopView(onTapButton: () -> Unit) {
  Column {

    Box(contentAlignment = Alignment.TopCenter) {
      Image(
        painter = painterResource(id = R.drawable.top),
        contentDescription = "hamburger"
      )
      Text(
        text = buildAnnotatedString {
          withStyle(style = SpanStyle(color = Orange900)) {
            append("Colbar's")
          }
          append(" burger")
        },
        modifier = Modifier.padding(top = 43.dp),
        color = Lime600,
        fontSize = 50.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Black,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        style = TextStyle(
          shadow = Shadow(
            color = Color.Black, blurRadius = 10f, offset = Offset(10f, 10f)
          )
        )
      )
    }
    Image(
      painter = painterResource(id = R.drawable.middle),
      contentDescription = "hamburger"
    )
    val scrollState = rememberScrollState()
    val menuItems = listOf(
      Pair("classicbeef", R.drawable.classicbeef),
      Pair("spicychicken", R.drawable.spicychicken),
      Pair("vegetarian", R.drawable.vegetarian),
      Pair("barbecue", R.drawable.barbecue),
      Pair("hotdog", R.drawable.hotdog),
      Pair("coffee", R.drawable.coffee),
      Pair("nugget", R.drawable.nugget)
    )
    Row(
      modifier = Modifier.horizontalScroll(scrollState)
    ) {

      menuItems.forEach { menuItem ->
        MenuView(modifier = Modifier
          .width(150.dp)
          .height(150.dp),
          id = menuItem.second,
          title = menuItem.first,
          onClick = { onTapButton() })
      }
    }
  }
}

@Preview(showBackground = true,
  widthDp = 360, heightDp = 740)
@Composable
fun TopViewPreview() {
    TopView(onTapButton = {})
}


@Composable
fun MenuView(
  modifier: Modifier = Modifier,
  @DrawableRes id: Int,
  title: String = "",
  onClick: (Int) -> Unit = {}
) {
  Box(modifier = modifier
    .clickable { onClick(id) }
    .padding(10.dp)
    .background(
      brush = Brush.linearGradient(
        colors = listOf(BaseColor, Orange400),
        start = Offset(0f, 80.dp.px), // グラデーションの開始位置（上部）
        end = Offset(0f, 150.dp.px) // グラデーションの終了位置（下部）
      ), shape = RoundedCornerShape(20.dp)
    ), contentAlignment = Alignment.Center) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        title, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
      )
      Image(
        painter = painterResource(id = id), contentDescription = null
      )
    }
  }
}

@Stable
inline val Dp.px: Float @Composable get() {
  val density = LocalDensity.current
  return with(density) { this@px.toPx() }
}

@Preview(showBackground = true)
@Composable
fun MenuViewPreview() {
  MenuView(
    modifier = Modifier
      .width(150.dp)
      .height(150.dp),
    id = R.drawable.classicbeef, title = "classicbeef", onClick = {}
  )
}

@Preview(showBackground = true)
@Composable
fun FontSamplePreview() {
  val fontWeight: List<Pair<String, FontWeight>> = listOf(
    Pair("Thin", FontWeight.Thin),
    Pair("ExtraLight", FontWeight.ExtraLight),
    Pair("Light", FontWeight.Light),
    Pair("Normal", FontWeight.Normal),
    Pair("Medium", FontWeight.Medium),
    Pair("SemiBold", FontWeight.SemiBold),
    Pair("Bold", FontWeight.Bold),
    Pair("ExtraBold", FontWeight.ExtraBold),
    Pair("Black", FontWeight.Black),
  )
  Column(modifier = Modifier.padding(30.dp)) {
    fontWeight.forEach {
      Row {
        Text(text = it.first, modifier = Modifier.width(100.dp))
        Text(text = "Colbar's burger", fontWeight = it.second)
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TextAlignSampePreview() {
  val textAlign: List<TextAlign> = TextAlign.values()

  Column(modifier = Modifier.padding(30.dp)) {
    textAlign.forEach {
      Row {
        Text(text = it.toString(), modifier = Modifier.width(50.dp))
        Text(
          text = "Colbar's burger",
          textAlign = it,
          modifier = Modifier
            .width(200.dp)
            .border(1.dp, Color.Red)
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun FontFamilyPreview() {
  val fontFamilies = listOf(
    FontFamily.Default to "Default",
    FontFamily.SansSerif to "SansSerif",
    FontFamily.Serif to "Serif",
    FontFamily.Monospace to "Monospace",
    FontFamily.Cursive to "Cursive"
  )
  Column(modifier = Modifier.padding(30.dp)) {
    fontFamilies.forEach {
      Row {
        Text(text = it.second, modifier = Modifier.width(100.dp))
        Text(text = "Colbar's burger", fontFamily = it.first)
      }
    }
  }
}