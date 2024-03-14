package com.example.webpageapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebView(url: String) {
  AndroidView(
    factory = { context ->
      android.webkit.WebView(context).apply {
        webChromeClient = android.webkit.WebChromeClient()
        webViewClient = android.webkit.WebViewClient()
        settings.javaScriptEnabled = true
        loadUrl(url)
      }
    }
  )
}

@Preview
@Composable
fun WebViewPreview() {
  WebView(url = "https://www.google.com/")
}
