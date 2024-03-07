package com.example.order

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.order.ui.theme.BaseColor
import com.example.order.ui.theme.Orange400
import com.example.order.ui.theme.OrderTheme
import com.example.order.ui.theme.Pink80

@Composable
fun RadioButtonWithText(
  text: String, selected: Boolean, onSelect: () -> Unit
) {
  Row(
    modifier = Modifier
      .padding(8.dp)
      .fillMaxWidth()
      .selectable(selected = selected, onClick = onSelect),
    verticalAlignment = Alignment.CenterVertically
  ) {
    RadioButton(
      selected = selected, onClick = null
    ) // RadioButtonのクリックはRow全体でハンドル
    Text(
      text = text, style = MaterialTheme.typography.bodyLarge
    )
  }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
  RadioButtonWithText(text = "ハンバーガー", selected = true, onSelect = {})
}


@Composable
fun TypographyList() {
  OrderTheme {
    val typography = arrayListOf(
      MaterialTheme.typography.displayMedium to "displayMedium",
      MaterialTheme.typography.displaySmall to "displaySmall",
      MaterialTheme.typography.headlineLarge to "headlineLarge",
      MaterialTheme.typography.headlineMedium to "headlineMedium",
      MaterialTheme.typography.headlineSmall to "headlineSmall",
      MaterialTheme.typography.titleLarge to "titleLarge",
      MaterialTheme.typography.titleMedium to "titleMedium",
      MaterialTheme.typography.titleSmall to "titleSmall",
      MaterialTheme.typography.bodyLarge to "bodyLarge",
      MaterialTheme.typography.bodyMedium to "bodyMedium",
      MaterialTheme.typography.bodySmall to "bodySmall",
      MaterialTheme.typography.labelLarge to "labelLarge",
      MaterialTheme.typography.labelMedium to "labelMedium",
      MaterialTheme.typography.labelSmall to "labelSmall",
    )

    Column(modifier = Modifier.padding(32.dp)) {
      typography.forEach { prop ->
        val style = prop.first as? TextStyle
        style?.let {
          Text(
            text = prop.second, style = it
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TypographyListPreview() {
  TypographyList()
}

@Composable
fun MainDishSection() {
  var selectedDish by remember { mutableStateOf("ハンバーガー") }
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(BaseColor, shape = MaterialTheme.shapes.extraLarge)
  ) {
    Column(
      Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .selectableGroup()
    ) {
      Text("メインを選択", style = MaterialTheme.typography.titleLarge)
      RadioButtonWithText(
        text = "ハンバーガー", selected = selectedDish == "ハンバーガー"
      ) { selectedDish = "ハンバーガー" }
      RadioButtonWithText(
        text = "チーズバーガー", selected = selectedDish == "チーズバーガー"
      ) { selectedDish = "チーズバーガー" }
    }
  }
}

@Preview(
  showBackground = true,
  backgroundColor = 0xFF000000
)
@Composable
fun MainDishSectionPreview() {
  MainDishSection()
}

@Composable
fun SideMenuSection() {
  var frenchFries by remember { mutableStateOf(false) }

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(BaseColor, shape = MaterialTheme.shapes.extraLarge)
  ) {
    Column(
      modifier = Modifier
        .padding(16.dp)
    ) {
      Text("サイドメニュー", style = MaterialTheme.typography.titleLarge)
      Row(
        modifier = Modifier.toggleable(
          value = frenchFries,
          onValueChange = { frenchFries = it }
        ),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Checkbox(
          checked = frenchFries,
          onCheckedChange = null
        )
        Text(
          "フレンチフライ", style = MaterialTheme.typography.bodyLarge
        )
      }
    }
  }
}

@Preview(
  showBackground = true,
  backgroundColor = 0xFF000000
)
@Composable
fun SideMenuSectionPreview() {
  SideMenuSection()
}

@Preview(showBackground = true)
@Composable
fun ShapesPreview() {
  Column(
    modifier = Modifier
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    Box(
      modifier = Modifier
        .width(100.dp)
        .background(
          color = Color.Blue,
          shape = MaterialTheme.shapes.extraSmall
        ),
      contentAlignment = Alignment.Center

    ) {
      Text(text = "extraSmall", color = Color.White)
    }
    Box(
      modifier = Modifier
        .width(100.dp)

        .background(color = Color.Blue, shape = MaterialTheme.shapes.small),
      contentAlignment = Alignment.Center
    ) {
      Text(text = "small", color = Color.White)
    }
    Box(
      modifier = Modifier
        .width(100.dp)
        .height(24.dp)
        .background(
          color = Color.Blue,
          shape = MaterialTheme.shapes.medium
        ),
      contentAlignment = Alignment.Center
    )
    {
      Text(text = "medium", color = Color.White)
    }
    Box(
      modifier = Modifier
        .width(100.dp)
        .height(32.dp)
        .background(color = Color.Blue, shape = MaterialTheme.shapes.large),
      contentAlignment = Alignment.Center
    )
    {
      Text(text = "large", color = Color.White)
    }
    Box(
      modifier = Modifier
        .width(100.dp)
        .height(56.dp)
        .background(
          color = Color.Blue,
          shape = MaterialTheme.shapes.extraLarge
        ),
      contentAlignment = Alignment.Center
    )
    {
      Text(text = "extraLarge", color = Color.White)
    }
  }
}

@Composable
fun SauceAmountSection() {
  var sauceAmount by remember { mutableStateOf(0f) }
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(BaseColor, shape = MaterialTheme.shapes.extraLarge)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Text(
        "ソースの量を調整できます",
        style = MaterialTheme.typography.titleLarge
      )
      Slider(
        value = sauceAmount,
        onValueChange = { sauceAmount = it },
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
      )
      Text(
        text = when {
          sauceAmount < 0.3f -> "少なめ"
          sauceAmount > 0.7f -> "多め"
          else -> "普通"
        },
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@Preview(
  showBackground = true,
  backgroundColor = 0xFF000000
)
@Composable
fun SauceAmountSectionPreview() {
  SauceAmountSection()
}

@Composable
fun DrinkSelectionSection() {
  var expanded by remember { mutableStateOf(false) }
  var selectedDrink by remember { mutableStateOf("選択してください") }
  val drinks = listOf("アイスコーヒー", "アイスカフェオレ", "コーラ")
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(BaseColor, shape = MaterialTheme.shapes.extraLarge)
  ) {
    Column(
      modifier = Modifier
        .padding(16.dp)
    ) {
      Text(
        "ドリンクを選択してください",
        style = MaterialTheme.typography.titleLarge
      )
      Box(
        modifier = Modifier
          .padding(16.dp)
          .fillMaxWidth()
      ) {
        OutlinedTextField(
          value = selectedDrink,
          onValueChange = { },
          modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true },
          trailingIcon = {
            Icon(
              Icons.Filled.ArrowDropDown,
              "dropdown",
              Modifier.clickable { expanded = true })
          },
          label = { Text("ドリンク") },
          readOnly = true
        )
        DropdownMenu(expanded = expanded,
          onDismissRequest = { expanded = false }) {
          drinks.forEach { drink ->
            DropdownMenuItem(text = { Text(text = drink) }, onClick = {
              selectedDrink = drink
              expanded = false
            })
          }
        }
      }
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun DrinkSelectionSectionPreview() {
  DrinkSelectionSection()
}

@Composable
fun OrderButtonSection(text: String, onClick: () -> Unit = {}) {
  val gradient = Brush.verticalGradient(
    colors = listOf(Pink80, Orange400)
  )
  Button(
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.Transparent
    ),
    contentPadding = PaddingValues(),
    modifier = Modifier
      .fillMaxWidth()
      .background(gradient, shape = MaterialTheme.shapes.extraLarge)
  ) {
    Text(
      text = text,
      color = Color.White,
      fontWeight = FontWeight.Bold,
      fontSize = 40.sp
    )
  }
}

@Preview(showBackground = true)
@Composable
fun OrderButtonSectionPreview() {
  OrderButtonSection("注文する")
}

@Composable
fun OrderView(
  @DrawableRes imageRes: Int = R.drawable.classicbeef,
  onTapButton: () -> Unit = {}
) {
  val scrollState = rememberScrollState()
  Column(
    modifier = Modifier
      .padding(16.dp)
      .verticalScroll(scrollState),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(id = R.drawable.order_screen),
      contentDescription = "order screen",
      modifier = Modifier.fillMaxWidth(),
      contentScale = ContentScale.FillWidth
    )
    Box(
      modifier = Modifier.padding(32.dp).fillMaxWidth(),
      contentAlignment = Alignment.Center

    ) {
      Image(
        painter = painterResource(
          id = R.drawable.order_background),
        contentDescription = "hamburger",
      )
      Image(
        painter = painterResource(id = imageRes),
        contentDescription = "hamburger",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
      )
    }
    MainDishSection()
    SideMenuSection()
    SauceAmountSection()
    DrinkSelectionSection()
    OrderButtonSection("注文する", onClick = onTapButton)
  }
}

@Preview(showBackground = true,
  widthDp = 400, heightDp = 1200,
  backgroundColor = 0xFF000000)
@Composable
fun OrderViewPreview() {
  OrderView()
}

