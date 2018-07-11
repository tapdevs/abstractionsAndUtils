package com.tapdevs.abstractions.views

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import com.tapdevs.abstractions.R
import com.tapdevs.abstractions.utils.AbstractionOrUtilsConstants


class BrowsingActivity : AppCompatActivity(){
    lateinit var webView: WebView
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url : String = intent?.getStringExtra(AbstractionOrUtilsConstants.BROWSER_ACTIVITY_URL) ?: ""
        if(url.equals("")){
            Toast.makeText(this,"Cannot load url",Toast.LENGTH_LONG).show()
            finish()
        }
        setContentView(R.layout.activity_web_view)
        webView = findViewById<WebView>(R.id.webView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    fun setTitle(title : String){
        actionBar.title = title
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}