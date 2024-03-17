package com.example.cherryblossoms

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.cherryblossoms.ui.theme.CherryBlossomsTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalFoundationApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CherryBlossomsTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          val jsonString = getJson(resources)
          val cherryList = getCherryList(jsonString)
          val titles = listOf("桜100選", "Wikipedia")
          val pagerState = rememberPagerState(pageCount = { titles.size })
          val scope = rememberCoroutineScope()
          Column {
            TabRow(
              selectedTabIndex = pagerState.currentPage
            ) {
              titles.forEachIndexed { index, title ->
                Tab(selected = pagerState.currentPage == index, onClick = {
                  scope.launch {
                    pagerState.animateScrollToPage(index)
                  }
                }, text = { Text(title) })
              }
            }
            HorizontalPager(state = pagerState) { page ->
              when (page) {
                0 -> CherryList(cherryList) { cherry ->
                  openGoogleMaps(Pair(cherry.latitude, cherry.longitude))
                }

                1 -> WikipediaView { search ->
                  val url = "https://ja.wikipedia.org/wiki/${search.title}"
                  openBrowser(url)
                }
              }
            }
          }
        }
      }
    }
  }

  fun getJson(resources: Resources): String {
    val inputStream = resources.assets.open("100Cherry_List.json")
    inputStream.use { inputStream ->
      inputStream.bufferedReader().use { bufferedReader ->
        return bufferedReader.readText()
      }
    }
  }

  fun getCherryList(str: String): List<Cherry> {
    val obj = Json.decodeFromString<List<Cherry>>(str)
    return obj
  }

  fun openGoogleMaps(coordinates: Pair<String, String>) {
    val gmmIntentUri =
      Uri.parse("geo:${coordinates.first},${coordinates.second}")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")
    startActivity(mapIntent)
  }

  fun openBrowser(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
  }

}