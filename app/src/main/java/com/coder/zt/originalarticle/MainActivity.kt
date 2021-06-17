package com.coder.zt.originalarticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coder.zt.originalarticle.test.JsoupTest

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        JsoupTest().parseHtml(HtmlArticleData.htmlData)
    }
}